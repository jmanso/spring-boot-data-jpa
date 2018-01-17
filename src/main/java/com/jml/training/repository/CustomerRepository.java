package com.jml.training.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.jml.training.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

	List<Customer> findByLastName(String lastName);
	
	@Query("select c from Customer c where c.name = :name")
  	Customer findByName(String name);
	
	@Query("select c from Customer c where c.name = :name")
	Page<Customer> findByName(@Param("name") String name, Pageable pageable);

}
