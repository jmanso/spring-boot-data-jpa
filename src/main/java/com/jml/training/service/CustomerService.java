package com.jml.training.service;

import java.util.List;

import com.jml.training.model.Customer;

public interface CustomerService {

	List<Customer> findCustomer();

	Customer findCustomerById(int id);
	
	List<Customer> findByLastName(String lastName);

	Customer saveCustomer(Customer customer);

	Customer updateCustomer(Customer customer);

	void deleteCustomer(int id);

	void deleteAll();

}
