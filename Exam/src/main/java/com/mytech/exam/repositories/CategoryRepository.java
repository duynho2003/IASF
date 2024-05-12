package com.mytech.exam.repositories;

import org.springframework.data.repository.CrudRepository;

import com.mytech.exam.entities.Category;

public interface CategoryRepository extends CrudRepository<Category, Long>{

}
