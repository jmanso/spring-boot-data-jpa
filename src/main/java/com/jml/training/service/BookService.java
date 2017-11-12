package com.jml.training.service;

import java.util.List;

import com.jml.training.model.Book;
import com.jml.training.model.Customer;

public interface BookService {
	
	List<Book> getBooks();
	
	public List<Book> findBooksByCustomer(Customer customer);
	
	Book getBook(int id);
	
	Book saveBook(Book book);

}
