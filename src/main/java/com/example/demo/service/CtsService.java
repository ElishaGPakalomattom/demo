package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.demo.controller.CtsException;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;

public interface CtsService {

//	public Employee getEmployee(int id) throws CtsException;
	public EmployeeDto getEmployee(int id) throws CtsException;

	public String getDept(int id);

	public List<EmployeeDto> getEmployeesBySalaryRange(BigDecimal min, BigDecimal max) throws CtsException;


	List<Employee> getallemp() throws CtsException;

	public List<EmployeeDto> getallempDtoReturn()throws CtsException;

	public int addEmp(EmployeeDto empDto) throws CtsException;

	public EmployeeDto updatEmail1(int id, String email)throws CtsException;

	public void deletemapping(int id) throws CtsException;

	public void updatEmail(int id, String email) throws CtsException;

}
