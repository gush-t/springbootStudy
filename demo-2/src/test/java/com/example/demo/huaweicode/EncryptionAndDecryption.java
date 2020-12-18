package com.example.demo.huaweicode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EncryptionAndDecryption {

    /**
     * 针对字符串进行加密和解密
     *
     * step1 encryption
     *          字母：1.大写转小写，小写转大写，后一位字母，如果z之后为a
     *          数字：后一位数字，9之后是0
     *
     * step2 decryption 解密是加密的逆序
     */

    @Test
    public void encryptionAndDecryption() throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String encryptionStr = reader.readLine();
        //String decryptionStr = reader.readLine();
        String encryption = getResultByTarget("abcdefg",true);
        String decryption = getResultByTarget("BCDEFGH",false);
        Assertions.assertEquals("BCDEFGH",encryption);
        Assertions.assertEquals("abcdefg",decryption);
    }

    /**
     * 获取加密后的字符串
     * @param decryptionStr
     * @return
     */
    private String getDecryptionResult(String decryptionStr) {
        StringBuffer stringBuffer = new StringBuffer();
        char[] strChar = decryptionStr.toCharArray();
        for (int i = 0; i < strChar.length; i++) {
            char charStr = strChar[i];
            if (charStr >= 'a' && charStr <= 'z'){
                if (charStr == 'z'){
                    charStr = 'A';
                }else {
                    charStr = (char) (charStr-31);
                }
            }else if (charStr >='A' && charStr <= 'Z'){
                if (charStr == 'Z'){
                    charStr = 'a';
                }else {
                    charStr = (char) (charStr+33);
                }
            }else if (charStr >= '0' && charStr <= '9'){
                if (charStr == '9'){
                    charStr = '0';
                }else {
                    charStr = (char) (charStr+1);
                }
            }
            stringBuffer.append(charStr);
        }
        return stringBuffer.toString();
    }



    private String getResultByTarget(String target,boolean encryption){

        StringBuffer stringBuffer = new StringBuffer();
        char[] strChar = target.toCharArray();
        for (int i = 0; i < strChar.length; i++) {
            char charStr = strChar[i];
            if (charStr >= 'a' && charStr <= 'z'){
                if (encryption){
                    if (charStr == 'z'){
                        charStr = 'A';
                    }else {
                        charStr = (char) (charStr-31);
                    }
                }else {
                    if (charStr == 'a'){
                        charStr = 'Z';
                    }else {
                        charStr = (char) (charStr-33);
                    }
                }

            }else if (charStr >='A' && charStr <= 'Z'){
                if (encryption){
                    if (charStr == 'Z'){
                        charStr = 'a';
                    }else {
                        charStr = (char) (charStr+33);
                    }
                }else {
                    if (charStr == 'A'){
                        charStr = 'z';
                    }else {
                        charStr = (char) (charStr+31);
                    }
                }

            }else if (charStr >= '0' && charStr <= '9'){
                if (encryption){
                    if (charStr == '9'){
                        charStr = '0';
                    }else {
                        charStr = (char) (charStr+1);
                    }
                }else {
                    if (charStr == '0'){
                        charStr = '9';
                    }else {
                        charStr = (char) (charStr-1);
                    }
                }

            }
            stringBuffer.append(charStr);
        }
        return stringBuffer.toString();
    }
}
