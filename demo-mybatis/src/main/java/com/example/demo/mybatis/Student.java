/** 
 * Project Name:demo-mybatis 
 * File Name:Student.java 
 * Package Name:com.example.demo.mybatis 
 * Date:2020-10-16 17:32:55 
 * Copyright (c) 2020, 18534132836@126.com All Rights Reserved. 
 * 
 */  
package com.example.demo.mybatis;

import java.io.Serializable;

/** 
 
 * @date: 2020-10-16 17:32:55 
 * @author gushaohua
 * @since JDK 1.8 
 */
public class Student implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer stuNo;
	
	private String stuName;
	
	
	
	

	public Integer getStuNo() {
		return stuNo;
	}

	public void setStuNo(Integer stuNo) {
		this.stuNo = stuNo;
	}

	public String getStuName() {
		return stuName;
	}

	public void setStuName(String stuName) {
		this.stuName = stuName;
	}
	
	
	
}
