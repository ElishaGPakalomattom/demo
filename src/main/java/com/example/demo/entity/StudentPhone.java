package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "student_phone")
public class StudentPhone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String phoneNumber;
    
    @ManyToOne
    @JoinColumns({
        @JoinColumn(name = "student_id", referencedColumnName = "studentId"),
        @JoinColumn(name = "department_code", referencedColumnName = "departmentCode"),
        @JoinColumn(name = "batch_year", referencedColumnName = "batchYear")
    })
    private Student student;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String list) {
		this.phoneNumber = list;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
    
	

}
