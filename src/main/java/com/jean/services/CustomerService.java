package com.jean.services;

import com.jean.entity.Customer;
import com.jean.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class CustomerService {
	private final CustomerRepository repo;

	@Autowired
	public CustomerService(CustomerRepository repo) {
		this.repo = repo;
	}

	public List<Customer> list() {
		return repo.findAll();
	}
	
	public Optional<Customer> get(String id) {
		return repo.findById(id);
	}
	
	public Customer save(Customer customer) {
		return repo.save(customer);
	}
	
	public void delete(String id) {
		repo.deleteById(id);
	}
}
