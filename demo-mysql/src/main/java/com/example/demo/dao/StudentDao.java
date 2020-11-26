package com.example.demo.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.Entity.Student;

@Repository
public interface StudentDao  extends JpaRepository<Student, Integer>{

	/**
	 * 
	 * @param stuName
	 * @param stuClass
	 * @return
	 */
	//Student findByStuNameAndClass(String stuName ,String stuClass);
	
	/**
	 * 
	 * @param stuAge
	 * @return
	 */
	@Query( value = "select * form student where stuAge = ?1", nativeQuery = true)
	Student findByStuAge(Integer stuAge);
	
	/**
	 * 
	 * @param specification
	 * @param pageable
	 * @return
	 */
	Page<Student> findStudentByClass(Specification<Student> specification,Pageable pageable);
	
	
}
