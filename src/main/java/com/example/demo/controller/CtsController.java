package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Employee;
import com.example.demo.service.CtsService;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.core.util.StringUtil;

@RestController
public class CtsController {

	private static final String Employee = null;
	@Autowired
	private CtsService ctsservice;

	@Autowired
	private Environment environment;

	@Value("${API.UPDATE_SUCCESS}") // new way of writing
	private String xyz;

//*********************************************************pathVariable
	// http://localhost:8080/employee/1
//	@GetMapping("/employee/{id}")
	// if returning all details of that id, then ResponseEntity<Employee>, return
	// ResponseEntity.ok(Employee); change in catch also
//	public ResponseEntity<EmployeeDto> getMethodName(@PathVariable("id") int id) throws Exception {
//		EmployeeDto empDto = new EmployeeDto();
//		try {
//			// int id1 = Integer.parseInt(id);
//			Employee emp = ctsservice.getEmployee(id);
//			empDto.setName(emp.getName());
//			return ResponseEntity.ok(empDto);
//		} catch (CtsException e) {
//			e.printStackTrace();
//			empDto.setMessage(e.getMessage());
//			return new ResponseEntity<>(empDto ,HttpStatus.INTERNAL_SERVER_ERROR);
//		}
//	}
	// http://localhost:8080/employee/1
	// using DTO class
	@GetMapping("/employee/{id}")
	public ResponseEntity<EmployeeDto> getMethodName(@PathVariable("id") int id) throws Exception {
		try {
			EmployeeDto empDto = ctsservice.getEmployee(id);
			return ResponseEntity.ok(empDto);
		} catch (CtsException e) {
			e.printStackTrace();
			EmployeeDto empDto = new EmployeeDto();
			empDto.setMessage(e.getMessage());
			return new ResponseEntity<>(empDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	http://localhost:8080/department/1
	@GetMapping("/department/{id}")
	public ResponseEntity<String> getDept(@PathVariable("id") int id) {
		String name1 = ctsservice.getDept(id);
		if (!StringUtil.isNullOrEmpty(name1)) {
			return new ResponseEntity<String>(name1, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(name1, HttpStatus.NO_CONTENT);
		}
	}

	// http://localhost:8080/employee/49000/71000
	@GetMapping("/employee/{min}/{max}")
	public ResponseEntity<List<EmployeeDto>> getEmployeesInSalaryRange(@PathVariable BigDecimal min,
			@PathVariable BigDecimal max) throws Exception {
		try {
			List<EmployeeDto> listitems = ctsservice.getEmployeesBySalaryRange(min, max);
			// return ResponseEntity.ok(listitems); or
			return new ResponseEntity<List<EmployeeDto>>(listitems, HttpStatus.OK);

		} catch (CtsException e) {
			List<EmployeeDto> listitems = new ArrayList<>();
			EmployeeDto dto = new EmployeeDto();
			dto.setMessage(e.getMessage());
			listitems.add(dto);
			e.printStackTrace();
            //git check
			return new ResponseEntity<List<EmployeeDto>>(listitems, HttpStatus.NO_CONTENT);
		}

	}

//Request param *****************************************************************
	// http://localhost:8080/department?id=1
	@GetMapping("/department")
	public ResponseEntity<String> getDept1(@RequestParam("id") int id) {
		String name1 = ctsservice.getDept(id);
		if (!StringUtil.isNullOrEmpty(name1)) {
			return new ResponseEntity<>(name1, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}
	}

	// http://localhost:8080/employee
//	@GetMapping("/employee")
//	public ResponseEntity<List<Employee>>getAllCust() throws CtsException{
//		try {
//		 List<com.example.demo.entity.Employee> listitems = ctsservice.getallemp();
//			return new ResponseEntity<>(listitems, HttpStatus.OK);
//		}catch(CtsException e){
//			List<Employee> listitems = new ArrayList<>();
//			EmployeeDto dto = new EmployeeDto();
//			dto.setMessage(e.getMessage());
//			
//			e.printStackTrace();
//			
//			return new ResponseEntity<>(listitems,HttpStatus.OK);//here if i need to print the error message, then it cant be list employee but dto has to be ued. so we use dto as safe practice
//			
//		}
//		
//
//	}
	@GetMapping("/employee")
	public ResponseEntity<List<EmployeeDto>> getAllCust() throws CtsException {
		try {
			List<EmployeeDto> listitems = ctsservice.getallempDtoReturn();
			return new ResponseEntity<>(listitems, HttpStatus.OK);
		} catch (CtsException e) {
			List<EmployeeDto> listitems = new ArrayList<>();
			EmployeeDto dto = new EmployeeDto();
			dto.setMessage(e.getMessage());
			listitems.add(dto);
			e.printStackTrace();

			return new ResponseEntity<>(listitems, HttpStatus.OK);

		}

	}

	// http://localhost:8080/employee
	// {
//    "name": "Alice",
//    "department": "Finance",
//    "email": "alice@example.com",
//    "salary": 65000.00
//}
//	@PostMapping("/employee")
//	public ResponseEntity<String> addEmployee(@RequestBody EmployeeDto empDto) throws CtsException {
//		try {
//			int id = ctsservice.addEmp(empDto);
//			return ResponseEntity.ok("New employee of id " + id + " is added");
//		}
//
//		catch (Exception e) {
//			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//		}
//
//	}
	
	@PostMapping("/employee")
	public ResponseEntity<String> addEmployee2(@RequestBody String request) throws CtsException {
		try {
			ObjectMapper objectMapper = new ObjectMapper(); // string to object
		    EmployeeDto empDto = objectMapper.readValue(request, EmployeeDto.class);
		    
		    String temp = objectMapper.writeValueAsString(empDto);//obj to string
		    System.out.println(temp);
			int id = ctsservice.addEmp(empDto);
			return ResponseEntity.ok("New employee of id " + id + " is added");
		}

		catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}


	///// put with status message return
//	http://localhost:8080/employee/3
//	{
//	    "email": "liya1@example.com"
//	}
	@PutMapping("/employee/{id}")
	public ResponseEntity<String> updatedetails(@PathVariable int id, @RequestBody EmployeeDto emp)
			throws CtsException {
		try {
			ctsservice.updatEmail(id, emp.getEmail());
// String successMessage = environment.getProperty("API.UPDATE_SUCCESS");--> old method
//return new ResponseEntity<>(successMessage + ": " + id, HttpStatus.OK);
			return new ResponseEntity<>(xyz + ": " + id, HttpStatus.OK);
		} catch (CtsException e) {
			e.printStackTrace();
			return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	///// put with entire value return
//	http://localhost:8080/employee/3
//	{
//	    "email": "liya1@example.com"
//	}
//	@PutMapping("/employee/{id}")
//	public ResponseEntity<EmployeeDto> updatedetails1(@PathVariable int id,@RequestBody EmployeeDto emp) throws CtsException{
//	try {
//	 EmployeeDto x = ctsservice.updatEmail1(id,emp.getEmail());
//	
//	      return new ResponseEntity<>(x, HttpStatus.OK);
//	    } catch (CtsException e) {
//	    	EmployeeDto errorDto = new EmployeeDto();
//	        errorDto.setMessage(e.getMessage());
//	        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
//	    }	
//	}
	
	
	///// put without passing any primary key in path
//	{
//    "id":4,
//    "name": "Alice",
//    "department": "Finance",
//    "email": "alice11@example.com",
//    "salary": 65000.00
//}
	// http://localhost:8080/employee/update
	@PutMapping("/employee/update")
	public ResponseEntity<EmployeeDto> updatedetails11(@RequestBody EmployeeDto emp) throws CtsException {
		try {
			EmployeeDto x = ctsservice.updatEmail1(emp.getId(), emp.getEmail());

			return new ResponseEntity<>(x, HttpStatus.OK);
		} catch (CtsException e) {
			EmployeeDto errorDto = new EmployeeDto();
			errorDto.setMessage(e.getMessage());
			return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// http://localhost:8080/employee/6
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteemployee(@PathVariable int id) throws CtsException {
		try {
			ctsservice.deletemapping(id);
			return ResponseEntity.ok(" employee of id " + id + " is deleted");
		} catch (Exception e) {

			e.printStackTrace();
			return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	// if ResponseEntity<EmployeeDto>, then
//	catch (Exception e) {
//        EmployeeDto errorDto = new EmployeeDto();
//        errorDto.setMessage(e.getMessage());
//        return new ResponseEntity<>(errorDto, HttpStatus.INTERNAL_SERVER_ERROR);	

}
