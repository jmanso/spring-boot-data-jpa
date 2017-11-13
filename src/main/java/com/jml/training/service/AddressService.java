package com.jml.training.service;

import com.jml.training.model.Address;

public interface AddressService {
	
	Address findAddress(int id);
	
	Address saveAddress(Address address);

}
