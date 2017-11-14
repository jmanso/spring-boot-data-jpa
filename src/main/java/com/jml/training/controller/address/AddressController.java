package com.jml.training.controller.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jml.training.model.Address;
import com.jml.training.model.Customer;
import com.jml.training.service.AddressService;
import com.jml.training.service.CustomerService;

@RestController
@RequestMapping(value = "/address")
public class AddressController {

	@Autowired
	private AddressService addressService;
	
	@Autowired
	private CustomerService customerService;
	
	@GetMapping(value = "/{addressId}")
	public Address getAddress(@PathVariable("addressId") final int id) {
		return addressService.findAddress(id);
	}
	
	@GetMapping(value = "/customer/{customerId}")
	public Address getAddressByCustomer(@PathVariable("customerId") final int customerId) {
		Customer customer = customerService.findCustomerById(customerId); 
		return addressService.findByCustomer(customer);
	}
	
}
