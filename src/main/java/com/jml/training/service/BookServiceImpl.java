package com.jml.training.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jml.training.model.Book;
import com.jml.training.model.Customer;
import com.jml.training.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> findBooks() {
		return bookRepository.findAll();
	}

	@Override
	public Book findBook(int id) {
		return bookRepository.findOne(id);
	}

	@Override
	@Transactional
	public Book saveBook(Book book) {
		return bookRepository.save(book);		
	}

	@Override
	public List<Book> findByCustomerId(Customer customer) {
		return bookRepository.findBooksByCustomerId(customer.getId());
	}
	
}
