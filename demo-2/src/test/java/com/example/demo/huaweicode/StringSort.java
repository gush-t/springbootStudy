package com.example.demo.huaweicode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringSort {

    // string sort
    //rule 1 ignore lowerCase upperCase
    //rule 2 if 字符相同，保持原有的顺序
    //rule 3 特殊字符，位置不变

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String statement = null;
        while ((statement = reader.readLine()) != null){
            // 内排序，直接交换排序是稳定的，可以保持原有的顺序，冒泡排序不行（如何改造）
            //step1 利用直接交换排序，将字母进行排序
            //step2 将字母序替换原字符串
            char[] chars = statement.toCharArray();
            char[] caseSort = new char[chars.length];
            int swapIndex =0;
            for (char i ='A'; i <='Z' ; i++){
                for (int j = 0 ; j < chars.length; j++){
                    if (chars[j] == i || (char)(chars[j] -32) == i){
                        caseSort[swapIndex++] = chars[j];
                    }
                }
            }
            swapIndex = 0 ;
            for (int i = 0 ; i < chars.length; i++){
                if ((chars[i] >= 'A' && chars[i] <= 'Z') || (chars[i] >= 'a' && chars[i] <= 'z')){
                    chars[i] = caseSort[swapIndex++];
                }
            }
            System.out.println(String.valueOf(chars));
        }
    }

    @Test
    public void ruleOne() throws IOException {
        String testStr = "A Famous Saying: Much Ado About Nothing (2012/8).";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String statement = null;
       // while ((statement = reader.readLine()) != null){
            // 内排序，直接交换排序是稳定的，可以保持原有的顺序，冒泡排序不行（如何改造）
            //step1 利用直接交换排序，将字母进行排序
            //step2 将字母序替换原字符串
            char[] chars = testStr.toCharArray();
            char[] caseSort = new char[chars.length];
            int swapIndex =0;
            for (char i ='A'; i <='Z' ; i++){
                for (int j = 0 ; j < chars.length; j++){
                    if (chars[j] == i || (char)(chars[j] -32) == i){
                        caseSort[swapIndex++] = chars[j];
                    }
                }
            }
            swapIndex = 0 ;
            for (int i = 0 ; i < chars.length; i++){
                if ((chars[i] >= 'A' && chars[i] <= 'Z') || (chars[i] >= 'a' && chars[i] <= 'z')){
                    chars[i] = caseSort[swapIndex++];
                }
            }
            System.out.println(String.valueOf(chars));
            Assertions.assertEquals("A aaAAbc dFgghh: iimM nNn oooos Sttuuuy (2012/8).",String.valueOf(chars));
       // }
    }

    //直接交换排序
    @Test
    public void swapSortTest(){
        Integer[] strArrays = {12,10,2};
        Integer tempString =0;
        List<Integer> list  = new ArrayList<>(Arrays.asList(strArrays));
        //从第二位开始和前一位开始比较
        for (int i = 1; i < strArrays.length; i++) {
            int j = i-1;
            tempString = strArrays[i]; //临时变量中存的是第二位的值
            //通过循环判断和之前位置的数据进行比较，如果大小不同，则进行位置交换
            while (j>=0 && strArrays[j].compareTo(tempString)>0){
                strArrays[j+1] = strArrays[j];//数值大的数据后移
                j = j-1;
            }
            strArrays[j+1] = tempString; //交换数据迁移，回填
        }
        Arrays.stream(strArrays).forEach(System.out::println);
        list.stream().sorted().forEach(System.out::println);

    }

    //冒泡排序

    @Test
    public void bubbleSortTest(){
        Integer[] strArrays = {1,10,2,2,2,100,1};
        Integer tempString =0;
        List<Integer> list  = new ArrayList<>(Arrays.asList(strArrays));
        //循环N遍，两两交换
        boolean swapNo = true;
        Integer tempIneger = 0;
        for (int i = 0; i < strArrays.length; i++) {
            for (int j = 1; j < strArrays.length; j++) {
                if (strArrays[j-1]>strArrays[j]){
                    tempIneger = strArrays[j-1];
                    strArrays[j-1] = strArrays[j];
                    strArrays[j] = tempIneger;
                    swapNo = false;
                }
            }
            if (swapNo){
                return;
            }

        }
        Arrays.stream(strArrays).forEach(System.out::println);

    }

}
