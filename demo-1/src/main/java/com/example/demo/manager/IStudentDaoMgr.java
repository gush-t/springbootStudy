package com.example.demo.manager;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.dao.Student;

public interface IStudentDaoMgr extends CrudRepository<Student, Integer> {
	
	
	Student findByName(String name);
	
	List<Student> findAllStu();

}
