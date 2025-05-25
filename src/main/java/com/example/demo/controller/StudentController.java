package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.example.demo.dto.StudentDto;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {
	private static final Logger logger = LoggerFactory.getLogger(StudentController.class);
	@Autowired
	StudentService studentService;

//	{
//	    "studentId": 103,
//	    "departmentCode": "CSE",
//	    "batchYear": 2025,
//	    "name": "Ron",
//	    "email": "lron@example.com",
//	    "phoneNumbers": [
//	        "1111",
//	        "222222",
//	        "333333"
//	    ]
//	}
//	http://localhost:8080/student/update/v1
	@PostMapping("/update/v1")
	public ResponseEntity<String> addStudent(@RequestBody StudentDto studentdto) throws CtsException {
		try {
			logger.info("Service is running... {} {}", studentdto.getStudentId(),studentdto.getName());
			logger.info("Service is running...");
			logger.debug("Debugging some issue...");
			logger.error("An error occurred!");

			studentService.addstudent(studentdto);
			return ResponseEntity.ok("New student of id  is added");
		}

		catch (Exception e) {
			e.printStackTrace();

			return new ResponseEntity<>("Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
