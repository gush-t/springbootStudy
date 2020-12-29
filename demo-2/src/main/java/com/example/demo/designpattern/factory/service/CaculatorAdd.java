package com.example.demo.designpattern.factory.service;

import java.math.BigDecimal;

public class CaculatorAdd extends OperaterCaculator {

    public CaculatorAdd() {
        super();
    }

    @Override
    public BigDecimal getResult() {
        BigDecimal result = new BigDecimal(0);
        BigDecimal numberA = getNumberA();
        BigDecimal numberB = getNumberB();
        result = numberA.add(numberB);
        return result;
    }

}
