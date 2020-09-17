package com.example.demo.designpattern.factory.service;

import java.math.BigDecimal;

public class SimpleFactoryDesignPattern {

	public OperaterCaculator createCaculator(String operate) {
		OperaterCaculator caculator = new OperaterCaculator();
		switch (operate) {
		case "+":
			caculator = new CaculatorAdd();
			break;

		default:
			break;
		}
		return caculator;
	}

}
