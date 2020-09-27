package com.example.demo.designpattern.strategy.service;

import java.math.BigDecimal;

public class SettleIntegral extends SettleAccounts {

	/**
	 * 客户累计积分
	 */
	private int tenantIngegral;
	
	/**
	 * 减免积分额度
	 */
	private static int freeIntegral = 300;
	/**
	 * 积分减免金额
	 */
	private static int freeCash =10;
	
	@Override
	public BigDecimal settleCashAccounts(BigDecimal goodsNumber, BigDecimal goodsPrice) {
		BigDecimal total = goodsNumber.multiply(goodsPrice);
		total = total.subtract(new BigDecimal(this.tenantIngegral/freeIntegral*freeCash));
		return total;
	}
	

	public SettleIntegral() {
		super();
	}
	
	

	

	public SettleIntegral(int tenantIngegral) {
		super();
		this.tenantIngegral = tenantIngegral;
	}

	public int getTenantIngegral() {
		return tenantIngegral;
	}

	public void setTenantIngegral(int tenantIngegral) {
		this.tenantIngegral = tenantIngegral;
	}

	public int getFreeIntegral() {
		return freeIntegral;
	}


	public void setFreeIntegral(int freeIntegral) {
		this.freeIntegral = freeIntegral;
	}


	public int getFreeCash() {
		return freeCash;
	}

	public void setFreeCash(int freeCash) {
		this.freeCash = freeCash;
	}
	
	
	

}
