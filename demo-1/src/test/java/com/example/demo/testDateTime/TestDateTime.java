package com.example.demo.testDateTime;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

public class TestDateTime {
	
	
	@Test
	public void testDate() {
		//字符串和日期之间的转换
		String strDay = "20190801";
		DateTimeFormatter dtf =  DateTimeFormatter.ofPattern("yyyyMMdd");
		//字符串转换为日期
		LocalDate date = LocalDate.parse(strDay, dtf);
		System.out.println(date.toString());
		System.out.println(date.getMonthValue());
		System.out.println(date.getDayOfWeek());
		System.out.println(date.getDayOfYear());
		//日期转换为字符
		System.out.println(date.format(dtf));
	}
	
	@Test
	public void testCaculator() {
		double nubOne = 1;
		double nubTwo = 3;
		String operate = "+";
		Double resultDouble = 0d;
		String strOperate = "+-*/";
		if(strOperate.contains(operate.trim())) {
			resultDouble = 0d;
		}
		System.out.println(resultDouble);
	}

}
