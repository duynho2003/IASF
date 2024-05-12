package com.mytech.exam.services;

import java.util.List;

import com.mytech.exam.entities.Product;

public interface ProductService {

	public void save(Product product);
	public void update(Product product);
	public List<Product> listAll();
	public Product get(long id);
	public void delete(long id);
}
