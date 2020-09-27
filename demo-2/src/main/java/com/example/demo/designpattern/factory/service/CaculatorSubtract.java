package com.example.demo.designpattern.factory.service;

import java.math.BigDecimal;

public class CaculatorSubtract extends OperaterCaculator {

	@Override
	public BigDecimal getResult() {

		BigDecimal result = new BigDecimal("0");
		BigDecimal numberA = getNumberA();
		BigDecimal numberB = getNumberB();
		result = numberA.subtract(numberB);
		return result;
	}
}
