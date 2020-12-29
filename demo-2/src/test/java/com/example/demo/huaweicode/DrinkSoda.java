package com.example.demo.huaweicode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DrinkSoda {

    public static void main(String[] args) {
        //喝汽水，3个空瓶子换一瓶汽水，
        // 最后如果剩下两个空瓶，可以和老板进行置换
        //这个转换为数学问题，就是商和余数的问题,能被3整除，商和余数相加在除以3，直到商为0
        //step1 输入空瓶子的个数和接收输入的数值
        Scanner scanner = new Scanner(System.in);
        int emptyNumber = 0;

        List<Integer> resultList = new ArrayList<>();

        //step2 处理一个空瓶子数值可以置换多少瓶汽水
        while ((emptyNumber = Integer.valueOf(scanner.nextLine())) != 0) {

            if (emptyNumber > 0 && emptyNumber <= 100) {
                int sodaNumber = 0;
                while (true) {
                    int quotients = emptyNumber / 3;
                    int remainders = emptyNumber % 3;
                    emptyNumber = quotients + remainders;
                    if (quotients == 0) {
                        if (emptyNumber == 2) {
                            sodaNumber = quotients + sodaNumber + 1;
                        }
                        break;
                    } else {
                        sodaNumber = quotients + sodaNumber;
                    }
                    System.out.println(sodaNumber);
                }
                resultList.add(sodaNumber);
            }
        }
        resultList.stream().forEach(System.out::println);
    }

    @Test
    public void drinkSodaTest() {
        //喝汽水，3个空瓶子换一瓶汽水，
        // 最后如果剩下两个空瓶，可以和老板进行置换
        //这个转换为数学问题，就是商和余数的问题,能被3整除，商和余数相加在除以3，直到商为0
        //step1 输入空瓶子的个数和接收输入的数值
        Scanner scanner = new Scanner(System.in);
        int emptyNumber = 0;
        int sodaNumber = 0;
        List<Integer> resultList = new ArrayList<>();

        //step2 处理一个空瓶子数值可以置换多少瓶汽水
        while ((emptyNumber = Integer.valueOf(scanner.nextLine())) != 0) {
            if (emptyNumber > 0 && emptyNumber <= 100) {
                while (true) {
                    int quotients = emptyNumber / 3;
                    int remainders = emptyNumber % 3;
                    emptyNumber = quotients + remainders;
                    if (quotients == 0) {
                        if (emptyNumber == 2) {
                            sodaNumber = quotients + sodaNumber + 1;
                            break;
                        }
                    }
                    sodaNumber = quotients + sodaNumber;
                }
                resultList.add(sodaNumber);
            }
        }
        resultList.stream().forEach(System.out::println);
    }
}
