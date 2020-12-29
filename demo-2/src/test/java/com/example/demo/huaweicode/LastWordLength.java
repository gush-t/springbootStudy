package com.example.demo.huaweicode;

import java.util.Scanner;

public class LastWordLength {

    /**
     * 输出字符串最后一个单词的长度
     *
     * @param str
     * @return
     */
    public static int lastWordLength(String str) {
        int length = 0;
        String word = str.substring(str.lastIndexOf(" ") + 1);
        return word.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (str.length() == 0 || str.length() > 5000) {
            System.out.println("0");
            return;
        }
        System.out.println(lastWordLength(str));
    }

    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String[] arrayStr = a.split(" ");
        System.out.println(arrayStr[arrayStr.length - 1].length());
    }

}
