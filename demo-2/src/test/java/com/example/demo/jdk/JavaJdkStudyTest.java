package com.example.demo.jdk;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.jupiter.api.Test;

public class JavaJdkStudyTest {
	
	
	@Test
	public void  testFloatDouble() {
		double nub01 = 0.1;
		double nub02 = 0.2;
		//assertThat(2).isEqualTo(nub02/nub01);
		System.out.println(nub02-nub01);
		System.out.println(0.2+0.1);
		BigDecimal number01 = new BigDecimal("1");
		BigDecimal number02 = new BigDecimal("3");
		System.out.println(number01.add(number02));
		System.out.println(number01.subtract(number02).setScale(3));
		System.out.println(number01.multiply(number02));
		System.out.println(number01.divide(number02,3,BigDecimal.ROUND_HALF_UP));	
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
	}
}
