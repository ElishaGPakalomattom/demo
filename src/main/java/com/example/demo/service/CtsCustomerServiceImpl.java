package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.CtsException;
import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Customer;
import com.example.demo.entity.CustomerId;
import com.example.demo.entity.Employee;
import com.example.demo.repository.CtsRepositoryCustomer;

@Service
public class CtsCustomerServiceImpl implements CtsCustomerService{
 
	@Autowired
	private CtsRepositoryCustomer ctsrepositorycustomer;
	
	@Override
	public CustomerDto getEmployee(int id, String regionCode, String accountType) throws CtsException {
		CustomerId pk = new CustomerId();
		pk.setCustomerId(id);
		pk.setRegionCode(regionCode);
		pk.setAccountType(accountType);

		Optional<Customer> x = ctsrepositorycustomer.findById(pk);
		CustomerDto customerdto = new CustomerDto();
		if (x.isPresent()) {
			Customer result = x.get();
			// salary check
			customerdto.setName(result.getName());
			return customerdto;
		} else {
			throw new CtsException("no customer");
		}

	}

}
