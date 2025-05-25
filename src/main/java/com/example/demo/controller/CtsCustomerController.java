package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.CtsCustomerService;

//multiple primary key
@RestController
@RequestMapping("/customer")
public class CtsCustomerController {
	@Autowired
	private CtsCustomerService ctscustomerservice;
	@GetMapping("/{customerId}/{regionCode}/{accountType}")
	public ResponseEntity<CustomerDto> getMethodName(@PathVariable("customerId") int customerId,@PathVariable("regionCode") String regionCode,@PathVariable("accountType") String accountType) throws Exception {
		try {
			CustomerDto customerdto = ctscustomerservice.getEmployee(customerId,regionCode,accountType);
			return ResponseEntity.ok(customerdto);
		} catch (CtsException e) {
			e.printStackTrace();
			CustomerDto customerdto1 = new CustomerDto();
			customerdto1.setMessage(e.getMessage());
			return new ResponseEntity<CustomerDto> (customerdto1 ,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
