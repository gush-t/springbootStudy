package com.example.demo.util;

import java.math.BigDecimal;
import java.util.Optional;

import com.example.demo.designpattern.factory.service.OperaterCaculator;
import com.example.demo.designpattern.factory.service.SimpleFactoryDesignPattern;

public class CaculatorUtil {


    public static BigDecimal caculatorPattern(BigDecimal nubOne, BigDecimal nubTwo, String operate) {
        OperaterCaculator operateObject = SimpleFactoryDesignPattern.createCaculator(operate);
        OperaterCaculator operateOptional = Optional.ofNullable(operateObject).orElse(new OperaterCaculator() {

            @Override
            public BigDecimal getResult() {
                // TODO Auto-generated method stub
                return new BigDecimal("0");
            }
        });
        operateOptional.setNumberA(nubOne);
        operateOptional.setNumberB(nubTwo);
        return operateOptional.getResult();

    }


    public static Double caculator(Double nubOne, Double nubTwo, String operate) {
        Double strResult = 0d;
        switch (operate) {
            case "+":
                strResult = nubOne + nubTwo;
                break;
            case "-":
                strResult = nubOne - nubTwo;
                break;
            case "/":
                strResult = nubOne / nubTwo;
                break;
            case "*":
                strResult = nubOne * nubTwo;
                break;

            default:
                break;
        }
        return strResult;


    }

}