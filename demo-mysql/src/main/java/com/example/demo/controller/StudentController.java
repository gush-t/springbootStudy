package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.Entity.Student;
import com.example.demo.service.StudentService;

import java.util.List;

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
	@DeleteMapping("/deleteStudentById")
	public void deleteStudentById(
			@RequestParam(required = true) Integer stuId) {
		studentService.deleteById(stuId);
	}
	@GetMapping("/findAllStudent")
	@ResponseBody
	public List<Student> findAll(){
		return studentService.findAll();
	}
	@PostMapping("/saveStudent")
	public void saveStudent(
			@RequestBody Student student){
		studentService.save(student);
	}

	@PutMapping("/updateStudent")
	public void updateStudent(
			@RequestBody Student student){
		studentService.save(student);
	}


}
