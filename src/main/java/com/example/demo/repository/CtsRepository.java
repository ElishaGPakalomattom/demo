package com.example.demo.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Employee;

@Repository
public interface CtsRepository extends JpaRepository<Employee, Integer> {

	//List<Employee> findBySalaryBetween(BigDecimal min, BigDecimal max);

@Query("SELECT e FROM Employee e WHERE e.salary BETWEEN :min AND :max")
 List<Employee> findBySalaryBetween(@Param("min") BigDecimal min, @Param("max") BigDecimal max);



}
