package com.example.demo.huaweicode;

import java.math.BigDecimal;
import java.util.Scanner;

import org.junit.jupiter.api.Test;


public class Approximate {

    @Test
    public void approximateValue() {
        Scanner scanner = new Scanner(System.in);
        BigDecimal number = new BigDecimal(0);
        while ((number = new BigDecimal(scanner.nextLine())) != null) {
            System.out.println(number.setScale(0, BigDecimal.ROUND_HALF_UP));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal number = new BigDecimal(0);
        if ((number = new BigDecimal(scanner.next())) != null) {
            System.out.println(number.setScale(0, BigDecimal.ROUND_HALF_UP).toString());
        } else {
            System.out.println("0");
        }
    }

}
