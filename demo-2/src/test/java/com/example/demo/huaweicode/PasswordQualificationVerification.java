package com.example.demo.huaweicode;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class PasswordQualificationVerification {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strInput = null;
        List<String> resultList = new ArrayList<>();
        while ((strInput = scanner.nextLine()) .length() >0){
            //TODO Password length eight verification
            boolean lengthLessEight = getResultLength(strInput);
            //TODO 包括大小写字母.数字.其它符号,以上四种至少三种
            boolean containsLessThree = getResultContains(strInput);
            //TODO 不能有相同长度大于2的子串重复
            boolean repetitionSubstring = getResultSubstring(strInput);
            if (lengthLessEight && containsLessThree && repetitionSubstring){
                resultList.add("OK");
            }else{
                resultList.add("NG");
            }
        }
        resultList.stream().forEach(System.out::println);
    }

    @Test
    public  void testQualificationVerification(){
        Scanner scanner = new Scanner(System.in);
        String strInput;
        List<String> resultList = new ArrayList<>();
        while ((strInput = scanner.nextLine()) != null){
            //TODO 密码长度大于8
            boolean lengthLessEight = getResultLength(strInput);
            //TODO 包括大小写字母.数字.其它符号,以上四种至少三种
            boolean containsLessThree = getResultContains(strInput);
            //TODO 不能有相同长度大于2的子串重复
            boolean repetitionSubstring = getResultSubstring(strInput);
            if (lengthLessEight && containsLessThree && repetitionSubstring){
                resultList.add("OK");
            }else{
                resultList.add("NG");
            }
        }
        resultList.stream().forEach(System.out::println);
    }

    /**
     * 判断密码字符串中是否存在重复的3个相连字符的子串<br></>
     * ture: 不包含重复的3个相连字符的子串，否则false<br></>
     * @param strInput
     * @return
     */
    private static boolean getResultSubstring(String strInput) {
       //TODO 就判断字符大小为3的重复子串是否存在
       char[] charStr =  strInput.toCharArray();
        //TODO 1. 循环获取3个相连子串
        for (int i = 0; i < charStr.length -2; i++) {
            for (int j = (i+3); j < charStr.length-2; j++) {
                //TODO 2. 子串和后续字符进行比较
                if(charStr[i] == charStr[j]
                && charStr[i+1] == charStr[j+1]
                && charStr[i+2] == charStr[j+2]){
                    return  false;
                }
            }
        }
       return true;
    }

    /**
     * 判断字符组成是否包含大写字母，小写字母，数字，或者特殊字符中的3种或者3中之上<br></>
     * true:密码字符串包含3种及之上的种类，否则false<br></>
     * @param strInput
     * @return
     */
    private static boolean getResultContains(String strInput) {
        boolean containsLessThree;
        int[] count = new int[4];
        char[] charStr = strInput.toCharArray();
        for (int i = 0; i < charStr.length; i++) {
            if (charStr[i] >= 0 && charStr[i] < 10) {
                count[0] = 1;
            } else if (charStr[i] >= 'a' && charStr[i] <= 'z') {
                count[1] = 1;
            } else if (charStr[i] >= 'A' && charStr[i] <= 'Z') {
                count[2] = 1;
            } else {
                count[3] = 1;
            }
        }
        AtomicInteger countKind = new AtomicInteger();
        for (int i = 0; i < count.length; i++) {
            countKind.set(count[i] + countKind.get());
        }
        containsLessThree = countKind.get() >= 3;
        return containsLessThree;
    }

    /**
     * 判断字符长度是否大于8，
     * false:字符长度小于8<br></>
     * true:字符长度大于等于8<br></>
     * @param strInput
     * @return
     */
    private static boolean getResultLength(String strInput) {
        boolean lengthLessEight;
        lengthLessEight = strInput.length()>=8;
        return lengthLessEight;
    }
}
