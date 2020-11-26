package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Entity.Student;
import com.example.demo.service.StudentService;

@RestController
@RequestMapping(value = "/student")
public class StudentController {
	
	@Autowired
	public StudentService studentService;
	
	@GetMapping("/getStudentById")
	public Student getStudentById(
			@RequestParam(required = true) Integer stuId) {
		return studentService.findById(stuId);
	}

}
