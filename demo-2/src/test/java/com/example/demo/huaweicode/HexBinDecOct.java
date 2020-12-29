package com.example.demo.huaweicode;

import java.math.BigInteger;
import java.util.Scanner;

import org.junit.jupiter.api.Test;


public class HexBinDecOct {

    @Test
    public void hexBinTest() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String string = (String) scanner.nextLine();
            if (string.equals("") == false) {
                System.out.println(new BigInteger(string, 16).toString(10));
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = Integer.valueOf(scanner.nextLine());
        System.out.println(binaryNumber(number));
    }

    public static int binaryNumber(int number) {
        String strBinary = Integer.toBinaryString(number);
        char[] charArray = strBinary.toCharArray();
        int oneCountOfBinary = 0;
        for (int i = 0; i < charArray.length; i++) {
            if ('1' == charArray[i]) {
                oneCountOfBinary++;
            }
        }
        return oneCountOfBinary;
    }
}
