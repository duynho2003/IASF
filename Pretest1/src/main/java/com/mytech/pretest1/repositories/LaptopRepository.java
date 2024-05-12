package com.mytech.pretest1.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.mytech.pretest1.entities.Laptop;

public interface LaptopRepository extends CrudRepository<Laptop, Long>{
	
	@Query(value = "SELECT l FROM Laptop l WHERE l.title LIKE '%' || :searchText || '%' OR l.brand LIKE '%' || :searchText || '%'")
	public List<Laptop> search(@Param("searchText") String searchText);

}
