package com.mytech.mvcshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mytech.mvcshop.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
