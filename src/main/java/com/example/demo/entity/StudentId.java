package com.example.demo.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class StudentId implements Serializable{
    
	private Integer studentId;
    private String departmentCode;
    private Integer batchYear;
    
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
	@Override
	public int hashCode() {
		return Objects.hash(batchYear, departmentCode, studentId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		StudentId other = (StudentId) obj;
		return Objects.equals(batchYear, other.batchYear) && Objects.equals(departmentCode, other.departmentCode)
				&& Objects.equals(studentId, other.studentId);
	}
	public StudentId() {
		super();
		this.studentId = studentId;
		this.departmentCode = departmentCode;
		this.batchYear = batchYear;
	}
	

}
