package com.jml.training.controller.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jml.training.model.Book;
import com.jml.training.model.Customer;
import com.jml.training.service.BookService;
import com.jml.training.service.CustomerService;

@RestController
@RequestMapping(value = "/book")
public class BookController {

	@Autowired
	private BookService bookService;
	
	@Autowired
	private CustomerService customerService;

	@GetMapping(value = "/all")
	public List<Book> getBooks() {
		return bookService.getBooks();
	}

	@GetMapping(value = "/{bookId}")
	public Book getBook(@PathVariable("bookId") final int id) {
		return bookService.getBook(id);
	}
	
	@GetMapping(value = "/customer/{customerId}")
	public List<Book> getBooksByCustomer(@PathVariable("customerId") final int customerId) {
		Customer customer = customerService.findCustomerById(customerId); 
		return bookService.findBooksByCustomer(customer);
	}
	
}
