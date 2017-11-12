package com.jml.training.controller.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jml.training.model.Customer;
import com.jml.training.service.CustomerService;

@RestController
@ExposesResourceFor(value = CustomerResource.class)
@RequestMapping(value = "/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value="/greeting/{name}")
	public String greetings(@PathVariable("name") final String customer) {
		return String.format("Hello %s", customer);
	}
	
	@GetMapping(value="/all")
	public List<Customer> getCustomers() {
		return customerService.findCustomer();
	}
	
	@GetMapping(value="/{id}")
	public CustomerResource getCustomer(@PathVariable("id") final int id) {
		Customer customer = customerService.findCustomerById(id);
		return new CustomerResource(customer);
	}
	
	@PostMapping(value="/add")
	public Customer saveCustomer(@RequestBody final Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@PutMapping(value="/update")
	public Customer updateCustomer(@RequestBody final Customer customer) {
		return customerService.saveCustomer(customer);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void deleteCustomer(@PathVariable("id") final int id) {
		customerService.deleteCustomer(id);
	}
	
	@DeleteMapping(value="/delete/all")
	public void deleteCustomers() {
		customerService.deleteAll();
	}
	

}
