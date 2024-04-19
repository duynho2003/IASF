package com.mytech.mvcshop.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytech.mvcshop.entities.Customer;
import com.mytech.mvcshop.repositories.CustomerRepository;
import com.mytech.mvcshop.services.CustomerService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public void save(Customer customer) {
		customerRepository.save(customer);

	}

	@Override
	public void update(Customer customer) {
		customerRepository.save(customer);

	}

	@Override
	public List<Customer> listAll() {
		return customerRepository.findAll();
	}

	@Override
	public Customer get(long id) {
		return customerRepository.findById(id).get();
	}

	@Override
	public void delete(long id) {
		customerRepository.deleteById(id);

	}

	@Override
	public List<Customer> search(String searchText) {
		return null;
	}

}
