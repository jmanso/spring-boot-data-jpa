package com.jml.training.SpringDataJPA;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jml.training.model.Book;
import com.jml.training.model.Customer;
import com.jml.training.service.BookService;
import com.jml.training.service.CustomerService;

@SpringBootApplication
public class SpringDataJpaApplication {

	@Autowired
	CustomerService customerService;
	
	@Autowired
	BookService bookService;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run() {
		return args -> {
//			Stream.of(new Book("Book1", 10.0, new Date()), new Book("Book2", 20.0, new Date()),
//					new Book("Book3", 12.5, new Date())).forEach(bookService::saveBook);
//
//			Stream.of(
//					new Customer("Customer1", "Customer1",
//							Arrays.asList(bookService.getBook(1), bookService.getBook(2), bookService.getBook(3))),
//					new Customer("Customer2", "Customer2", Arrays.asList(bookService.getBook(2))),
//					new Customer("Customer3", "Customer3", Arrays.asList(bookService.getBook(3)))).forEach(x -> {
//						customerService.saveCustomer(x);
//						System.out.println(x);
//					});
			
			dataSave();
			showData();						
		};
	}
	
	@Transactional
	public void dataSave() {
		Customer customer1 = new Customer("Customer1", "Customer1");
		customer1.addBooks(new Book("Book1", 11.0, new Date()));
		customer1.addBooks(new Book("Book2", 12.0, new Date()));
		
		Customer customer2 = new Customer("Customer2", "Customer2");
		customer2.addBooks(new Book("Book3", 13.0, new Date()));
		
		customerService.saveCustomer(customer1);
		customerService.saveCustomer(customer2);
	}
	
	@Transactional
	public void showData() {
		System.out.println("Customer List");
		
		List<Customer> customerList = customerService.findCustomer();
		customerList.forEach(System.out::println);
		
		System.out.println("Book List");
		
		List<Book> bookList = bookService.getBooks();
		bookList.forEach(System.out::println);		
	}
}
