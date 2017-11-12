package com.jml.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jml.training.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findByLastName(String lastName);

}
