package com.example.demo.service;

import com.example.demo.controller.CtsException;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.EmployeeDto;

public interface CtsCustomerService {

	CustomerDto getEmployee(int id, String regionCode, String accountType)  throws CtsException;

}
