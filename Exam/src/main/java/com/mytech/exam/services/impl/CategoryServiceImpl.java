package com.mytech.exam.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mytech.exam.entities.Category;
import com.mytech.exam.repositories.CategoryRepository;
import com.mytech.exam.services.CategoryService;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void save(Category category) {
		categoryRepository.save(category);
	}

	@Override
	public void update(Category category) {
		Category dbCategory = categoryRepository.findById(category.getCatId()).get();
		dbCategory.setCatName(category.getCatName());
		
		categoryRepository.save(category);
		
	}

	@Override
	public List<Category> listAll() {
		// TODO Auto-generated method stub
		return (List<Category>) categoryRepository.findAll();
	}

	@Override
	public Category get(long id) {
		// TODO Auto-generated method stub
		return categoryRepository.findById(id).get();
	}

	@Override
	public void delete(long id) {
		categoryRepository.deleteById(id);
		
	}

}
