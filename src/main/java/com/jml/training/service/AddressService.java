package com.jml.training.service;

import com.jml.training.model.Address;
import com.jml.training.model.Customer;

public interface AddressService {
	
	Address findAddress(int id);
	
	Address findByCustomer(Customer customer);
	
	Address saveAddress(Address address);

}
