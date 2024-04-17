package com.mytech.mvcshop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytech.mvcshop.entities.Book;
import com.mytech.mvcshop.repositories.BookRepository;
import com.mytech.mvcshop.services.BookService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class BookServiceImpl implements BookService {

	@Autowired
	private BookRepository bookRepository;

	@Override
	public void save(Book book) {
		// Implement business logic
		bookRepository.save(book);
	}

	@Override
	public void update(Book book) {
		bookRepository.save(book);
	}

	@Override
	public List<Book> listAll() {
		return (List<Book>) bookRepository.findAll();
	}

	@Override
	public Book get(long id) {
		return bookRepository.findById(id).get();
	}

	@Override
	public void delete(long id) {
		bookRepository.deleteById(id);
	}

	@Override
	public List<Book> search(String searchText) {
		return bookRepository.search(searchText);
	}

}
