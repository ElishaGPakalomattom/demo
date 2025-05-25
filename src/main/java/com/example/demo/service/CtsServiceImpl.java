package com.example.demo.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.CtsException;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import com.example.demo.repository.CtsRepository;
import com.example.demo.repository.CtsRepositoryDept;

@Service
public class CtsServiceImpl implements CtsService {

	@Autowired
	private CtsRepository ctsrepository;
	@Autowired
	private CtsRepositoryDept ctsrepositorydept;

//	public Employee getEmployee(int id) throws CtsException {
//		Optional<Employee> empOpt = ctsrepository.findById(id);
//		if (empOpt.isPresent()) {
//			Employee emp = empOpt.get();
//			//salary check
//			if(emp.getSalary()>60000) {
//				return emp;
//			}
//			else {
//				
//				throw new CtsException(emp.getName() + " has salary less than 60k");
//			}
//			
//		} else {
//			throw new CtsException("no emploee");
//		}
//	}
	@Override
	public EmployeeDto getEmployee(int id) throws CtsException {
		Optional<Employee> empOpt = ctsrepository.findById(id);
		EmployeeDto empDto = new EmployeeDto();
		if (empOpt.isPresent()) {
			Employee emp = empOpt.get();
			// salary check
			empDto.setName(emp.getName());
			if (emp.getSalary() < 60000) {
				empDto.setMessage("salary less than 60k");
			}

		} else {
			throw new CtsException("no emploee");
		}
		return empDto;
	}

	@Override
	public String getDept(int id) {
		Optional<Department> name = ctsrepositorydept.findById(id);
		if (name.isPresent()) {
			String x = name.get().getName();
			return x;
		} else {
			return null;
		}

	}

	@Override
	public List<EmployeeDto> getEmployeesBySalaryRange(BigDecimal min, BigDecimal max) throws CtsException {
		List<Employee> x = ctsrepository.findBySalaryBetween(min,max);

	    if (x.isEmpty()) {
	        throw new CtsException("No employees found in the given salary range.");
	    }
		 List<EmployeeDto> dtoList = new ArrayList<>();
		   for (Employee emp : x) {
		        EmployeeDto dto = new EmployeeDto();
		        dto.setId(emp.getId());
		        dto.setName(emp.getName());
		        dtoList.add(dto);
		    }

		
		return dtoList;
	}

	@Override
	public List<Employee> getallemp() throws CtsException {
		// TODO Auto-generated method stub
		List<Employee> x = ctsrepository.findAll();
		if(x.isEmpty()) {
			 throw new CtsException("No employees");
		}
		return x;
	}

	@Override
	public List<EmployeeDto> getallempDtoReturn() throws CtsException {
		// TODO Auto-generated method stub
		List<Employee> x=ctsrepository.findAll();
		if(x.isEmpty()) {
			 throw new CtsException("No employees in table");
			 
		}
		 List<EmployeeDto> newlist1 = new ArrayList<>();
		   for (Employee emp : x) {
		        EmployeeDto dto = new EmployeeDto();
		        dto.setId(emp.getId());
		        dto.setName(emp.getName());
		        dto.setDepartment(emp.getDepartment());
		        dto.setEmail(emp.getEmail());
		        dto.setSalary(emp.getSalary());
		        newlist1.add(dto);
		    }
		return newlist1;
	}

	@Override
	public int addEmp(EmployeeDto empDto) throws CtsException {
		// TODO Auto-generated method stub
		Employee e= new Employee();
		e.setName(empDto.getName());
		e.setDepartment(empDto.getDepartment());
		e.setEmail(empDto.getEmail());
		e.setSalary(empDto.getSalary());
		
		ctsrepository.save(e);
		int id=e.getId();
		return id;
	}

	@Override
	public EmployeeDto updatEmail1(int id, String email) throws CtsException {
		Optional<Employee> x = ctsrepository.findById(id);
		 if (x.isEmpty()) {
		        throw new CtsException("No employees with this id.");
		    }
		 Employee e=x.get();
		 e.setEmail(email);
		 ctsrepository.save(e);
		 EmployeeDto edto=new EmployeeDto();
		 edto.setId(e.getId());
		 edto.setName(e.getName());
		 edto.setDepartment(e.getDepartment());
		 edto.setEmail(e.getEmail());
		 edto.setSalary(e.getSalary());
		return edto;
	}

	@Override
	public void deletemapping(int id) throws CtsException  {
	Optional<Employee> x = ctsrepository.findById(id);
	 if (x.isEmpty()) {
	        throw new CtsException("No employees with this id.");
	    }
	 ctsrepository.deleteById(id);
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatEmail(int id, String email) throws CtsException {
		// TODO Auto-generated method stub
		Optional<Employee> x = ctsrepository.findById(id);
		 if (x.isEmpty()) {
		        throw new CtsException("No employees with this id.");
		    }
		 Employee e=x.get();
		 e.setEmail(email);
		 ctsrepository.save(e); 
	}



}
