package com.jml.training.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jml.training.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {

}
