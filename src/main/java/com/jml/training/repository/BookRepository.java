package com.jml.training.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jml.training.model.Book;

public interface BookRepository extends JpaRepository<Book, Integer> {
	
	List<Book> findBooksByCustomer(int customerId);

}
