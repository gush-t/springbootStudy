package com.example.demo.designpattern.factory.service;

import java.math.BigDecimal;

/**
 * 开闭原则，对修改关闭，对扩展开放
 * @author TRS
 *
 */
public class OperaterCaculator {
	
	private BigDecimal numberA;
	
	private BigDecimal numberB;
	
	private BigDecimal result;
	
	

	public OperaterCaculator() {
		super();
	}
	
	
	public BigDecimal getResult() {
		
		
		return result;
		
	}

	public BigDecimal getNumberA() {
		return numberA;
	}

	public void setNumberA(BigDecimal numberA) {
		this.numberA = numberA;
	}

	public BigDecimal getNumberB() {
		return numberB;
	}

	public void setNumberB(BigDecimal numberB) {
		this.numberB = numberB;
	}
	
	
	

}
