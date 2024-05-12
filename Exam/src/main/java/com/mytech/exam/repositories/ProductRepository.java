package com.mytech.exam.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mytech.exam.entities.Product;

public interface ProductRepository extends CrudRepository<Product, Long>{

}
