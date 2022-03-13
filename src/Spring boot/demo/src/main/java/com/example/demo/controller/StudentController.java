package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Controller("/student")
public class StudentController {
	
	@Autowired
	static StudentRepository studentRepo;
	
	@PostMapping("/create")
	public static String createStudent(@RequestBody Student student) {
		
		studentRepo.save(student);
		
		return "Student with id: " + student.getId() + " is created";
		
	}

}
