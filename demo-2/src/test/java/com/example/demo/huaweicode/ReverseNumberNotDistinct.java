package com.example.demo.huaweicode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class ReverseNumberNotDistinct {

    @Test
    public void reverseNumberNotDistinct() {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        System.out.println(new StringBuffer(nextLine).reverse());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        String[] split = nextLine.split(" ");
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(split));
        Collections.reverse(arrayList);
        StringBuffer strBuffer = new StringBuffer();
        for (String string : arrayList) {
            strBuffer.append(string).append(" ");
        }
        System.out.println(strBuffer);
    }

    @Test
    public void reverseStringNotContainUpperCase() {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        String lowerCase = nextLine.toLowerCase();
        if (lowerCase.equals(nextLine)) {
            System.out.println(new StringBuffer(nextLine).reverse());
        } else {
            System.out.println("0");
        }
    }

    @Test
    public void reverseStatement() {
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        String[] split = nextLine.split(" ");
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(split));
        Collections.reverse(arrayList);
        StringBuffer strBuffer = new StringBuffer();
        for (String string : arrayList) {
            strBuffer.append(string).append(" ");
        }
        System.out.println(strBuffer);
    }

}
