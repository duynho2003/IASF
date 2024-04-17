package com.mytech.mvcshop.services;

import java.util.List;

import com.mytech.mvcshop.entities.Book;

public interface BookService {
	public void save(Book book);
	public void update(Book book);
	public List<Book> listAll();
	public Book get(long id);
	public void delete(long id);
	public List<Book> search (String searchText);
}
