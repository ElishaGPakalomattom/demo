package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Student;
import com.example.demo.entity.StudentId;

@Repository
public interface CtsRepositoryStudent extends JpaRepository<Student, StudentId> {

}
