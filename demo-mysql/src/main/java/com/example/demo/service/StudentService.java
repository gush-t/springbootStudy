package com.example.demo.service;

import org.springframework.data.domain.Page;

import com.example.demo.Entity.Student;

public interface StudentService {
	
	Student findById(Integer stuId);

	/**
	 * 
	 * @param stuName
	 * @param stuClass
	 * @return
	 */
	//Student findByStuNameAndClass(String stuName ,String stuClass);
	/**
	 * 
	 * @param specification
	 * @param pageable
	 * @return
	 */
	Page<Student> findStudentByClass(int page , int size , String stuClass);
	
}
