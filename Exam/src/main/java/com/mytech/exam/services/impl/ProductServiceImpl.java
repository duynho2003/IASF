package com.mytech.exam.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytech.exam.entities.Product;
import com.mytech.exam.repositories.ProductRepository;
import com.mytech.exam.services.ProductService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void save(Product product) {
		productRepository.save(product);
		
	}

	@Override
	public void update(Product product) {
		Product dbProduct = productRepository.findById(product.getId()).get();
		dbProduct.setName(product.getName());
		dbProduct.setPrice(product.getPrice());
		dbProduct.setQuantity(product.getQuantity());
		
		productRepository.save(product);
		
	}

	@Override
	public List<Product> listAll() {
		// TODO Auto-generated method stub
		return (List<Product>) productRepository.findAll();
	}

	@Override
	public Product get(long id) {
		// TODO Auto-generated method stub
		return productRepository.findById(id).get();
	}

	@Override
	public void delete(long id) {
		productRepository.deleteById(id);
		
	}
	
	
}
