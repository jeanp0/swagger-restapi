package com.jean.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jean.entity.Customer;


public interface ICustomerRepository extends JpaRepository<Customer, String>{
}
