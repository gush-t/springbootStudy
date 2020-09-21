package com.example.demo.designpattern.factory.service;

import java.math.BigDecimal;

public class CaculatorAdd extends OperaterCaculator {
	
	private int testStaticInvoke;
	
	private static int ds;

	@Override
	public BigDecimal getResult() {

		BigDecimal result = new BigDecimal(0);
		BigDecimal numberA = getNumberA();
		BigDecimal numberB = getNumberB();
		result = numberA.add(numberB);
		return result;
	}
	
	/**
	 * static method cannot invoke non-static field
	 */
	public static void add() {
		System.out.println(ds);
	}

	
	
	public int getTestStaticInvoke() {
		return testStaticInvoke;
	}

	public void setTestStaticInvoke(int testStaticInvoke) {
		this.testStaticInvoke = testStaticInvoke;
	}

}
