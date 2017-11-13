package com.jml.training.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "address")
public class Address implements Serializable {

	private static final long serialVersionUID = -3808536847029878816L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "address_id")
	private Integer id;

	private String street;

	@Column(name = "postal_code")
	private String postalCode;

	private String city;
	
	private String country;
	
	@OneToOne(mappedBy = "address", cascade = CascadeType.ALL)
	@JsonIgnore
	private Customer customer;
	
	public Address() {
	
	}
	
	public Address(String street, String postalCode, String city, String country) {
		this.street = street;
		this.postalCode = postalCode;
		this.city = city;
		this.country = country;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
		if (customer.getAddress() != this) {
			customer.addAddress(this);
		}
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", street=" + street + ", postalCode=" + postalCode + ", city=" + city
				+ ", country=" + country + "]";
	}

}
