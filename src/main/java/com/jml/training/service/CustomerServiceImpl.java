package com.jml.training.service;

import java.util.List;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jml.training.model.Customer;
import com.jml.training.repository.CustomerRepository;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@Override
	public List<Customer> findCustomer() {
		return (List<Customer>) customerRepository.findAll();
	}
	
	@Override
	public Customer findCustomerById(int id) {
		return (Customer) customerRepository.findOne(id);
	}
	
	@Override
	public List<Customer> findByLastName(String lastName) {
		return (List<Customer>) customerRepository.findByLastName(lastName);
	}
	
	@Override
	public Customer saveCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	@Override
	public Customer updateCustomer(Customer customer) {
		return customerRepository.save(customer);
	}
	
	@Override
    @Transactional(rollbackFor=EntityNotFoundException.class)
	public void deleteCustomer(int id) {
		Customer customer = findCustomerById(id);
		if (customer == null) 
			throw new EntityNotFoundException();
			
		customerRepository.delete(customer);
	}
	
	@Override
	public void deleteAll() {
		customerRepository.deleteAll();
	}

}
