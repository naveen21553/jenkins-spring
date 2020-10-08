package com.naveen.spring.springboot.data.repository;

import com.naveen.spring.springboot.data.entity.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{
    
}
