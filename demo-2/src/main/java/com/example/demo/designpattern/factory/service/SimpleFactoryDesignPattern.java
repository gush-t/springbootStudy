package com.example.demo.designpattern.factory.service;

public class SimpleFactoryDesignPattern {

    public static OperaterCaculator createCaculator(String operate) {
        OperaterCaculator caculator = null;
        switch (operate) {
            case "+":
                caculator = new CaculatorAdd();
                break;
            case "-":
                caculator = new CaculatorSubtract();
            default:
                break;
        }
        return caculator;
    }

}
