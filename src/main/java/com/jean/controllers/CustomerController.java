package com.jean.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.jean.entity.Customer;
import com.jean.entity.TransactionStatus;
import com.jean.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.spring.web.json.Json;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RequestMapping("/customer")
@RestController
public class CustomerController {

	private final CustomerService customerService;

	@Autowired
	public CustomerController(CustomerService customerService) {
		this.customerService = customerService;
	}


	@GetMapping
	public ResponseEntity<List<Customer>> list() {
		List<Customer> customers = customerService.list();

		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Customer>> get(@PathVariable String id) {
		Optional<Customer> customer = customerService.get(id);

		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<TransactionStatus> save(@RequestBody Customer customer) throws JsonProcessingException {
		TransactionStatus transactionStatus = new TransactionStatus();

		JsonObject jsonPayload = new JsonObject();
		Gson gson = new Gson();
//		ObjectMapper mapper = new ObjectMapper();

		Customer customerSaved = customerService.save(customer);
		jsonPayload.add("customerSaved", gson.toJsonTree(customerSaved));
//		JsonNode jsonPayload = mapper.convertValue(customerSaved, JsonNode.class);
		transactionStatus.setError(false);
		transactionStatus.setMessage("Se agregó un cliente correctamente a la base de datos.");
		transactionStatus.setPayload(jsonPayload);

		return new ResponseEntity<>(transactionStatus, HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<Boolean> update(@RequestBody Customer customer) {
		customerService.save(customer);
		
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable String id) {
		customerService.delete(id);
		
		return new ResponseEntity<>(true, HttpStatus.OK);
	}
}
