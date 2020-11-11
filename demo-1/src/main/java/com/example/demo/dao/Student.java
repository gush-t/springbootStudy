package com.example.demo.dao;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "`STUDENT`")
public class Student extends BaseEntity {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int id, String name) {
		super(id, name);
		// TODO Auto-generated constructor stub
	}
	
	

}
