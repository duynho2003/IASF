package com.mytech.pretest1.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytech.pretest1.entities.Laptop;
import com.mytech.pretest1.repositories.LaptopRepository;
import com.mytech.pretest1.services.LaptopService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class LaptopServiceImpl implements LaptopService{

	@Autowired
	private LaptopRepository laptopRepository;

	@Override
	public void save(Laptop laptop) {
		// Implement business logic
		laptopRepository.save(laptop);
		
	}

	@Override
	public void update(Laptop laptop) {
		Laptop dbLaptop = laptopRepository.findById(laptop.getId()).get();
		dbLaptop.setTitle(laptop.getTitle());
		dbLaptop.setBrand(laptop.getBrand());
		dbLaptop.setPrice(laptop.getPrice());
		dbLaptop.setImage(laptop.getImage());
		
		laptopRepository.save(dbLaptop);
		
	}

	@Override
	public List<Laptop> listAll() {
		// TODO Auto-generated method stub
		return (List<Laptop>) laptopRepository.findAll();
	}

	@Override
	public Laptop get(long id) {
		// TODO Auto-generated method stub
		return laptopRepository.findById(id).get();
	}

	@Override
	public void delete(long id) {
		laptopRepository.deleteById(id);
	}

	@Override
	public List<Laptop> search(String searchText) {
		return laptopRepository.search(searchText);
	}
}
