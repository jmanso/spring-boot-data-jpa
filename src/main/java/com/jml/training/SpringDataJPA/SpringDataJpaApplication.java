package com.jml.training.SpringDataJPA;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jml.training.model.Address;
import com.jml.training.model.Book;
import com.jml.training.model.Customer;
import com.jml.training.service.AddressService;
import com.jml.training.service.BookService;
import com.jml.training.service.CustomerService;

@SpringBootApplication
public class SpringDataJpaApplication {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	BookService bookService;
	
	@Autowired
	AddressService addressService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
			dataSave();
			showData();						
		};
	}
	
	public void dataSave() {
		Customer customer1 = new Customer("Customer1", "Customer1");
		customer1.addBooks(new Book("Book1", 11.0, new Date()));
		customer1.addBooks(new Book("Book2", 12.0, new Date()));
		
		Address address = new Address("St.Street 123", "98302", "Barcelona", "Spain");
		customer1.addAddress(address);
		
		Customer customer2 = new Customer("Customer2", "Customer2");
		customer2.addBooks(new Book("Book3", 13.0, new Date()));
		
		addressService.saveAddress(address);
		customerService.saveCustomer(customer1);
		customerService.saveCustomer(customer2);		
	}
	
	public void showData() {
		System.out.println("Customer List");
		List<Customer> customerList = customerService.findCustomer();
		customerList.forEach(System.out::println);
		
		System.out.println("Book List");		
		List<Book> bookList = bookService.findBooks();
		bookList.forEach(System.out::println);	
	}
}
