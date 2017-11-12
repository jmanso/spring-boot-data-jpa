package com.jml.training.controller.customer;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.jml.training.model.Address;
import com.jml.training.model.Book;
import com.jml.training.model.Customer;


public class CustomerResource extends ResourceSupport {
	
	private String name;
	
	private String lastName;

	private List<Book> books;
	
	private Address address;
	
	public CustomerResource(Customer customer) {
		this.name = customer.getName();
		this.lastName = customer.getLastName();
		this.books = new ArrayList<Book>(customer.getBooks());
		this.address = customer.getAddress();
		
	    add(linkTo(methodOn(CustomerController.class).getCustomer(customer.getId())).withSelfRel());
	}

	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public List<Book> getBooks() {
		return books;
	}


	public void setBooks(List<Book> books) {
		this.books = books;
	}


	public Address getAddress() {
		return address;
	}


	public void setAddress(Address address) {
		this.address = address;
	}

	

}
