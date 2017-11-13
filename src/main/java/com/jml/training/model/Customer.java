package com.jml.training.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer implements Serializable {

	private static final long serialVersionUID = 5763422568547501233L;

	@Id 
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="customer_id")
	private int id;
	
	private String name;
	
	private String lastName;

	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Book> books = new ArrayList<Book>();
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "address_id")
	private Address address;

	public Customer() {

	}
	
	public Customer(String name, String lastName) {
		this.name = name;
		this.lastName = lastName;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public void addBooks(Book book) {
		if (book.getCustomer() != this) {
			book.setCustomer(this);
		}
        this.books.add(book);
    }
	
	public Address getAddress() {
		return address;
	}

	public void addAddress(Address address) {
		this.address = address;
		if (address.getCustomer() != this) {
			address.setCustomer(this);
		}
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", lastName=" + lastName + "]";
	}

}
