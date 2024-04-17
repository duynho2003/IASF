package com.mytech.mvcshop.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mytech.mvcshop.entities.Book;

public interface BookRepository extends CrudRepository<Book, Long> {

	@Query(value = "SELECT b FROM Book b WHERE b.title LIKE '%' || :searchText || '%' OR b.author LIKE '%' || :searchText || '%'")
	public List<Book> search(@Param("searchText") String searchText);
}
