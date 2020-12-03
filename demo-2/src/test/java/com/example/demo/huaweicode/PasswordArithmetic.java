package com.example.demo.huaweicode;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class PasswordArithmetic {

    public static void main(String[] args) throws IOException {
        //TODO 密码算法：分为3部分
        //TODO 1.数字保持不变
        //TODO 2.小写字母转换为对应的数字： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0
        //TODO 3.大写字母转换为小写字母+1： A 转换为 b ; Z 转换为 a
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> passwordList = new ArrayList<>();
        String plaintext = null;
        while ((plaintext = bufferedReader.readLine()) != null){
            StringBuffer strPassword =new StringBuffer();
            char[] plaintextArray =  plaintext.toCharArray();
            for (int i = 0; i < plaintextArray.length; i++) {
                char passwordChar = plaintextArray[i];
                if (passwordChar >= '0' && passwordChar <= '9'){
                    strPassword.append(passwordChar);
                }else if(passwordChar >= 'a' && passwordChar <= 'z'){
                    strPassword.append(getLowerCaseResult(passwordChar));
                }else if(passwordChar > 'A' && passwordChar <= 'Z'){
                    strPassword.append(getUpperCase(passwordChar));
                }
            }
            passwordList.add(strPassword.toString());
        }
        passwordList.stream().forEach(System.out::println);
    }

    @Test
    public void passwordArithmeticTest() throws IOException {
        //TODO 密码算法：分为3部分
        //TODO 1.数字保持不变
        //TODO 2.小写字母转换为对应的数字： 1--1， abc--2, def--3, ghi--4, jkl--5, mno--6, pqrs--7, tuv--8 wxyz--9, 0--0
        //TODO 3.大写字母转换为小写字母+1： A 转换为 b ; Z 转换为 a
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> passwordList = new ArrayList<>();
        String plaintext = null;
        while ((plaintext = bufferedReader.readLine()) != null){
            StringBuffer strPassword =new StringBuffer();
           char[] plaintextArray =  plaintext.toCharArray();
            for (int i = 0; i < plaintextArray.length; i++) {
                char passwordChar = plaintextArray[i];
                if (passwordChar >= '0' && passwordChar <= '9'){
                    strPassword.append(passwordChar);
                }else if(passwordChar >= 'a' && passwordChar <= 'z'){
                    strPassword.append(getLowerCaseResult(passwordChar));
                }else if(passwordChar >= 'A' && passwordChar <= 'Z'){
                    strPassword.append(getUpperCase(passwordChar));
                }
            }
            passwordList.add(strPassword.toString());
        }
        passwordList.stream().forEach(System.out::println);
    }

    private static String getUpperCase(char passwordChar) {
        if (passwordChar == 90){
            return "a";
        }else {
             char chatPass = (char) (passwordChar+33);
            return String.valueOf(chatPass);
        }
    }

    private static int getLowerCaseResult(char passwordChar) {
        String passwordStr = String.valueOf(passwordChar);
        if ("abc".contains(passwordStr)){
            return 2;
        }else if("def".contains(passwordStr)){
            return 3;
        }else if("ghi".contains(passwordStr)){
            return 4;
        }else if("jkl".contains(passwordStr)){
            return 5;
        }else if("mno".contains(passwordStr)){
            return 6;
        }else if("pqrs".contains(passwordStr)){
            return 7;
        }else if("tuv".contains(passwordStr)){
            return 8;
        }else{
            return 9;
        }
    }
}
