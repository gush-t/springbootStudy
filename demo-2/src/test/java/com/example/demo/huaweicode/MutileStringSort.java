package com.example.demo.huaweicode;

import java.util.ArrayList;
import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class MutileStringSort {

    @Test
    public void stringSrot() {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int valueOf = Integer.valueOf(str);
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i = 0; i < valueOf; i++) {
            String strChar = scanner.nextLine();
            arrayList.add(strChar);
        }
        arrayList.stream().sorted().forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        int valueOf = Integer.valueOf(str);
        ArrayList<Object> arrayList = new ArrayList<>();
        for (int i = 0; i < valueOf; i++) {
            String strChar = scanner.nextLine();
            arrayList.add(strChar);
        }
        arrayList.stream().sorted().forEach(System.out::println);
    }

}
