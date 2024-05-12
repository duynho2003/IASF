package com.mytech.exam.services;

import java.util.List;

import com.mytech.exam.entities.Category;

public interface CategoryService {

	public void save(Category category);
	public void update(Category category);
	public List<Category> listAll();
	public Category get(long id);
	public void delete(long id);
}
