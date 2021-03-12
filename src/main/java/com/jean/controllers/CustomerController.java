package com.jean.controllers;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jean.entity.Customer;
import com.jean.entity.Log;
import com.jean.services.CustomerService;
import com.jean.services.LogService;

@CrossOrigin
@RequestMapping("/customer")
@RestController
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	@Autowired
	private LogService logService;

	@GetMapping
	public ResponseEntity<List<Customer>> list(@RequestHeader Map<String, String> headers) {
		List<Customer> customers = customerService.list();
		Log log = new Log();
		log.setDateTime(LocalDateTime.now());
		log.setControllerURI(headers.get("method"));
		logService.save(log);	
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Customer>> get(@PathVariable String id) {
		Optional<Customer> customer = customerService.get(id);

		return new ResponseEntity<>(customer, HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<Boolean> save(@RequestBody Customer customer) {
		customerService.save(customer);
		return new ResponseEntity<>(true, HttpStatus.OK);
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
