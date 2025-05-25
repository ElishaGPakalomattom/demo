package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	@EmbeddedId
	private StudentId id;
	private String name;
	private String email;

	@OneToMany(mappedBy = "student", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<StudentPhone> phoneNumbers = new ArrayList<>();

	public StudentId getId() {
		return id;
	}

	public void setId(StudentId id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<StudentPhone> getPhoneNumbers() {
		return phoneNumbers;
	}

	public void setPhoneNumbers(List<StudentPhone> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}

}
