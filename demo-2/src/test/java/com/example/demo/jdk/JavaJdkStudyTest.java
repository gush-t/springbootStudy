package com.example.demo.jdk;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.junit.jupiter.api.Test;
import org.springframework.format.annotation.DateTimeFormat;

public class JavaJdkStudyTest {
	
	public static List<String> listStatic  = new ArrayList<>(); 
	
	@Test
	public void  testFloatDouble() {
		double nub01 = 0.1;
		double nub02 = 0.2;
		//assertThat(2).isEqualTo(nub02/nub01);
		System.out.println(nub02-nub01);
		System.out.println(0.2+0.1);
		BigDecimal number01 = new BigDecimal("10");
		BigDecimal number02 = new BigDecimal("3");
		System.out.println(number01.add(number02));
		System.out.println(number01.subtract(number02).setScale(3));
		System.out.println(number01.multiply(number02));
		System.out.println(number01.divide(number02,3,BigDecimal.ROUND_HALF_UP));
		assertThat(new BigDecimal("13")).isEqualTo(number01.add(number02));
		assertThat(new BigDecimal("7.000")).isEqualTo(number01.subtract(number02).setScale(3));
		assertThat(new BigDecimal("30")).isEqualTo(number01.multiply(number02));
		assertThat(new BigDecimal("3.333")).isEqualTo(number01.divide(number02,3,BigDecimal.ROUND_HALF_UP));


	}
	
	/**
	 * 形参和实参 ，基本数据类型和引用类型
	 */

	@Test
	public void testParam() {
		int a = 1;
		int b = 2;
		int c = a;
		int d = b;
		String aa = "aa";
		String bb = "aa";
		assertThat(true).isEqualTo(aa==bb);
		 aa = "bb";		
		String ip = "123.212.13.23";
		int ipLastNumber = Integer.parseInt(ip.substring(ip.lastIndexOf(".")+1));
		String beginIpSub = ip.substring(0, ip.lastIndexOf(".") + 1); 
		System.out.println(beginIpSub);
		System.out.println(ipLastNumber);
		List<String> list = new ArrayList<>(100);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(i++);
		}
		 //String t = null;
		 //String e = Optional.of(t).orElse("gushaohua");
		 //System.out.println(e);
	}
	
	@Test
	public void testParameter() {
		String valueParam = "valueParameter";
		String referenceParam = valueParam;
		Integer intT = 0;
		Double doubleT =2.2;
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate.format(dtf));
	}
	
	@Test
	public void testMemory() {
		List<String> list = new ArrayList<>();
		while(true) {
			list.add(new String("gushaohua"));
		}
	}
	
	/**
	 * 内存溢出
	 */
	@Test
	public void testRuntimeConstantPool() {
		for (int i = 0; i < 1000; i++) {
			listStatic.add(Math.random()+"1");
		}	
		
	}
	//定个小目标，一个编程题，一个设计模式，一日一练
	
}
