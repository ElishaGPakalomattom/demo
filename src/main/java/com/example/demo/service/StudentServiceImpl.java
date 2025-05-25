package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.controller.CtsException;
import com.example.demo.dto.StudentDto;
import com.example.demo.entity.Student;
import com.example.demo.entity.StudentId;
import com.example.demo.entity.StudentPhone;
import com.example.demo.repository.CtsRepositoryStudent;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private CtsRepositoryStudent ctsrepositorystudent;

	@Override
	public void addstudent(StudentDto studentdto) throws CtsException {
		// TODO Auto-generated method stub
		StudentId s = new StudentId();
		s.setStudentId(studentdto.getStudentId());
		s.setBatchYear(studentdto.getBatchYear());
		s.setDepartmentCode(studentdto.getDepartmentCode());
		Optional<Student> x = ctsrepositorystudent.findById(s);
		if (x.isPresent()) {
			throw new CtsException("already existing");
		} else {
			Student ss=new Student();
			
			StudentId sid=new StudentId();
			sid.setStudentId(studentdto.getStudentId());
			sid.setDepartmentCode(studentdto.getDepartmentCode());
			sid.setBatchYear(studentdto.getBatchYear());
			ss.setId(sid);
			ss.setEmail(studentdto.getEmail());
			ss.setName(studentdto.getName());
			List<StudentPhone> studentPhones = new ArrayList<>();
			for(String pn : studentdto.getPhoneNumbers()) {
				StudentPhone phone =new StudentPhone();
				phone.setPhoneNumber(pn);
				studentPhones.add(phone);
				phone.setStudent(ss);
				
			}
			ss.setPhoneNumbers(studentPhones);	
			ctsrepositorystudent.save(ss);

		}

	}

}
