package com.mytech.edunext.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mytech.edunext.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
