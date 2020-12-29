package com.example.demo.designpattern.strategy.service;

import java.math.BigDecimal;

public class SettelNormal extends SettleAccounts {


    @Override
    public BigDecimal settleCashAccounts(BigDecimal goodsNumber, BigDecimal goodsPrice) {
        // TODO Auto-generated method stub
        return goodsNumber.multiply(goodsPrice);
    }

}
