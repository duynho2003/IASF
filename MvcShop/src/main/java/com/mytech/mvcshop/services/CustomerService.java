package com.mytech.mvcshop.services;

import java.util.List;

import com.mytech.mvcshop.entities.Customer;

public interface CustomerService {
	public void save(Customer customer);
	public void update(Customer customer);
	public List<Customer> listAll();
	public Customer get(long id);
	public void delete(long id);
	public List<Customer> search(String searchText);
}
