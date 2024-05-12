package com.mytech.pretest1.services;

import java.util.List;

import com.mytech.pretest1.entities.Laptop;

public interface LaptopService {

	public void save(Laptop laptop);
	public void update(Laptop laptop);
	public List<Laptop> listAll();
	public Laptop get(long id);
	public void delete(long id);
	public List<Laptop> search(String searchText);
}
