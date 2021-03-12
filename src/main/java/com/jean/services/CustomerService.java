package com.jean.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jean.entity.Customer;
import com.jean.repository.ICustomerRepository;


@Service
public class CustomerService {
	@Autowired
	private ICustomerRepository repo;

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
