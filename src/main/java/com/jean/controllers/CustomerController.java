package com.jean.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jean.entity.Customer;
import com.jean.services.CustomerService;

@CrossOrigin
@RequestMapping("/customer")
@RestController
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping
	public ResponseEntity<List<Customer>> list() {
		List<Customer> customers = customerService.list();
		
		return new ResponseEntity<>(customers, HttpStatus.OK);
	}
	
	@GetMapping("/{ci}")
	public ResponseEntity<Optional<Customer>> get(@PathVariable String id) {
		Optional<Customer> customer = customerService.get(id);

		return new ResponseEntity<>(customer, HttpStatus.OK);
	}
	@PostMapping("/{ci}")
	public ResponseEntity<Customer> 

}
