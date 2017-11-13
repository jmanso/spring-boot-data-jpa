package com.jml.training.service;

import java.util.List;

import com.jml.training.model.Book;
import com.jml.training.model.Customer;

public interface BookService {
	
	List<Book> findBooks();
	
	public List<Book> findByCustomerId(Customer customer);
	
	Book findBook(int id);
	
	Book saveBook(Book book);

}
