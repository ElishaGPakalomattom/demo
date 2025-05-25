package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerId;
import com.example.demo.entity.Employee;

public interface CtsRepositoryCustomer extends JpaRepository<Customer, CustomerId> {
    // Custom query methods can be defined here if necessary
}
