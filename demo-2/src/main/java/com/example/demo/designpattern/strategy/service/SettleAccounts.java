package com.example.demo.designpattern.strategy.service;

import java.math.BigDecimal;

public abstract class SettleAccounts {
	
	/**
	 * 结清现金账目
	 * @return
	 */
	public abstract BigDecimal settleCashAccounts(BigDecimal goodsNumber,BigDecimal goodsPrice);

}
