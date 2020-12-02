package com.example.demo.huaweicode;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class PasswordQualificationVerification {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String strInput = null;
        List<String> resultList = new ArrayList<>();
        StringBuffer stringBuffer = new StringBuffer();
        while ((strInput = bufferedReader.readLine()) != null ){
            //TODO Password length eight verification
            boolean lengthLessEight = getResultLength(strInput);
            if (lengthLessEight == false){
                stringBuffer.append("NG").append("\n");
                continue;
            }
            //TODO 包括大小写字母.数字.其它符号,以上四种至少三种
            boolean containsLessThree = getResultContains(strInput);
            System.out.println(containsLessThree);
            if (containsLessThree == false){
                stringBuffer.append("NG").append("\n");
                continue;
            }
            //TODO 不能有相同长度大于2的子串重复
            boolean repetitionSubstring = getResultSubstring(strInput);
            System.out.println(repetitionSubstring);
            if (repetitionSubstring == false){
                stringBuffer.append("NG").append("\n");
                continue;
            }else {
                stringBuffer.append("OK").append("\n");
            }
        }
        System.out.println(stringBuffer.toString());
        //resultList.stream().forEach(System.out::println);
    }

    @Test
    public  void testQualificationVerification() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = null;
        StringBuilder stringBuilder = new StringBuilder();
        while(null != (input = reader.readLine())) {
            char[] chars = input.toCharArray();
            if (input.length() < 9) {
                stringBuilder.append("NG").append("\n");
                continue;
            }
            boolean[] flag = new boolean[4];
            for (int i = 0; i < chars.length; i++) {
                if ('A' <= chars[i] && chars[i] <= 'Z') {
                    flag[0] = true;
                } else if ('a' <= chars[i] && chars[i] <= 'z') {
                    flag[1] = true;
                } else if ('0' <= chars[i] && chars[i] <= '9') {
                    flag[2] = true;
                } else {
                    flag[3] = true;
                }
            }
            int count = 0;
            for (int i = 0; i < 4; i++) {
                if (flag[i]) {
                    count++;
                }
            }
            if (count < 3) {
                stringBuilder.append("NG").append("\n");
                continue;
            }

            // 第三个条件
            boolean sign = true;   //不存在两个大于2的子串相同，即！（i=i+3,i+1=i+4,i+2=i+5）
            for (int i = 0; i < chars.length - 5; i++) {
                for (int j = i + 3; j < chars.length - 2; j++) {
                    if (chars[i] == chars[j] && chars[i + 1] == chars[j + 1] && chars[i + 2] == chars[j + 2]) {
                        sign = false;
                    }
                }
            }
            if (count >= 3 && sign) {
                stringBuilder.append("OK").append("\n");
            } else {
                stringBuilder.append("NG").append("\n");
            }
        }
        System.out.println(stringBuilder.toString());
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
        for (int i = 0; i < charStr.length -5; i++) {// 不够6个字符，不需要后续循环了
            for (int j = i+3; j < charStr.length-2; j++) {
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

    @Test
    public void test(){
        System.out.println(getResultSubstring("021AbcAbc111"));
    }

    /**
     * 判断字符组成是否包含大写字母，小写字母，数字，或者特殊字符中的3种或者3中之上<br></>
     * true:密码字符串包含3种及之上的种类，否则false<br></>
     * @param strInput
     * @return
     */
    private static boolean getResultContains(String strInput) {
        boolean containsLessThree;
        boolean[] count = new boolean[4];
        char[] charStr = strInput.toCharArray();
        for (int i = 0; i < charStr.length; i++) {
            if (charStr[i] >= '0' && charStr[i] <= '9') {// 注意：0 9 需要加单引号，转换为字符
                count[0] = true;
            } else if (charStr[i] >= 'a' && charStr[i] <= 'z') {
                count[1] = true;
            } else if (charStr[i] >= 'A' && charStr[i] <= 'Z') {
                count[2] = true;
            } else {
                count[3] = true;
            }
        }
        int countKind = 0;
        for (int i = 0; i < count.length; i++) {
            System.out.println(count[i]);
           if (count[i]){
               countKind ++ ;
           }
        }
        containsLessThree = countKind >= 3;
        return containsLessThree;
    }

    /**
     * 判断字符长度是否大于8，
     * false:字符长度小于8<br></>
     * true:字符长度大于8<br></>
     * @param strInput
     * @return
     */
    private static boolean getResultLength(String strInput) {
        boolean lengthLessEight;
        lengthLessEight = strInput.length()>8;
        return lengthLessEight;
    }
}
