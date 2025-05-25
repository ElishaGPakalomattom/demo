package com.example.demo.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class StudentDto {

    private Integer studentId;
    private String departmentCode;
    private Integer batchYear;
    private String name;
    private String email;
    @JsonProperty("grade_name")// we r passing grade_name in postman. but we r asking to map it to grade of dto. if we dont use jsonproperty , then grade may remain null.
    private String grade;
    private List<String> phoneNumbers;

	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public Integer getBatchYear() {
		return batchYear;
	}
	public void setBatchYear(Integer batchYear) {
		this.batchYear = batchYear;
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
	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}

	
    
}
