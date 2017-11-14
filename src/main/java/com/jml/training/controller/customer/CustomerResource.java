package com.jml.training.controller.customer;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import org.springframework.hateoas.ResourceSupport;

import com.jml.training.controller.address.AddressController;
import com.jml.training.controller.book.BookController;
import com.jml.training.model.Customer;

public class CustomerResource extends ResourceSupport {

	private String name;

	private String lastName;

	public CustomerResource(Customer customer) {
		this.name = customer.getName();
		this.lastName = customer.getLastName();

		add(linkTo(methodOn(CustomerController.class).getCustomer(customer.getId())).withSelfRel());
		add(linkTo(methodOn(BookController.class).getBooksByCustomer(customer.getId())).withRel("Books"));
		add(linkTo(methodOn(AddressController.class).getAddressByCustomer(customer.getId())).withRel("Address"));
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

}