package com.jml.training.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jml.training.model.Address;
import com.jml.training.repository.AddressRepository;

@Service
@Transactional
public class AddressServiceImpl implements AddressService {
	
	@Autowired
	private AddressRepository addressRepository;

	@Override
	public Address findAddress(int id) {
		return addressRepository.findOne(id);
	}

	@Override
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}

}
