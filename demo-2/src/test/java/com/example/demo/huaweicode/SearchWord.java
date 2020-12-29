package com.example.demo.huaweicode;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SearchWord {
    /**
     * 先输入单词的个数n，再输入n个单词。
     * 再输入一个单词，为待查找的单词x
     * 最后输入数字k
     */

    /**
     * 输出查找到x的兄弟单词的个数m
     * 然后输出查找到的按照字典顺序排序后的第k个兄弟单词，没有符合第k个的话则不用输出。
     */

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = null;
        List<String> list = new ArrayList<>();
        int searchIndex = 0;
        while ((inputStr = reader.readLine()) != null) {
            String[] strArrays = inputStr.split(" ");
            int size = Integer.valueOf(strArrays[0]);
            String targetStr = strArrays[strArrays.length - 2];
            searchIndex = Integer.valueOf(strArrays[strArrays.length - 1]);
            for (int i = 1; i <= size; i++) {
                if (checkBrother(targetStr, strArrays[i])) {
                    list.add(strArrays[i]);
                }
            }
        }
        System.out.println(list.size());
        if (list.size() > 0 && searchIndex <= list.size()) {
            Collections.sort(list);
            System.out.println(list.get(searchIndex - 1));
        }
    }

    @Test
    public void searchWordTest() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = "473 bb daccb caddd bddc c baa adb ad abbcb cdaa abab a abcc ddcbd cadcc cdacd aaa a b acccd bbb dacc cc acbdd bcbb ba bacaa adda acd aaad d ab acac bc dabab abcd aacba aba daa bb ad cddab a bbaa aacad cdac acbcc cada bacd adcad cdadc bcbcc aa b acd cbaac ddcd ccb dac a dac adbcb bcda dda a ab ca dd d abd a dbb ccabd bdddd abd adc aaa baccb ccdcd a da c cadc dcdbd d aa bb a cac c ad adb ca cdcc cadd dddca d cba cb caab caa dd cd bca abc cdaa cdb bad dad bda d ddbc dab baaa adaac b a dbccd bd b bdad cdacd baa ac ddcad d bb acc aa cd cbdbb bbbcb a cc aacc c aadc dbcd a bca dd abbb ccdcd ccd ab d a a dadcd dbd bcaa c cda b ddab caaaa cdcdb b acbc ccaa dabca dcd b ba dbcc da bdbcc ab abaca bb cddc caca da dadba accdd bdac dbcd bcbbd ab bd ccb ddaa aa b b d bddd cabac aaba ab ccdb db abbd ada bdadb c abba dd cdb bca cccda badba abaa ac aabad db ccbad bddd ada dba acba b bc dd bbbbd cc cbdd cd abcaa bb ddaca acadb bbbb bddcc bdada aaa bcbda c aaa aadd cdddc adb cdbab c cbca bb aacab acdb bbdab b acbda cbdcd bda bacdc db d adcbd bccc c aaa cdd bdcd bac a aaab ddbb cd ccdbb addcc cdc c ca baadc addba dbdbd dba bbdda bcb c cdad aacac dcada cb aaad a cccab caca aad bbb dd b babbb cba bdaca db bacd bc bcbda cdda bcccd bdcda bdbcd adb cbcb a c bacba abbb adab adab b b d bca badbc baa cdb b abc aabb b d c cdab cacda d cdcda adcdc bcc bbccd b adb caba cbaaa aadb dcc add bcac bacbd bb a b c cabaa c caad c aa bcc ccab ddc dadca cdcba aaba dabbd dcb a bddb bb a c c cbc ccd dd a cabbb b caadb cb dca cbb ddaa bcadc dab a bbda cd bc ccad bbd ab c acddd cdd dbbbb daaab abbb cabc add ca caa bbbb dcab daaaa baca dcd ccacb ba bddaa acac dbcc bcc cbbcc b abba daa dbab bcca ba aa d dcdc d dcaa cbcda bd b ccbcb baa dcacd d c cbda baba d abb c cbdc da dbbb cd aabc dadc b a ddb c ddd ccdc ccd cba dbaac dcccd ddbac dbbdd bad bcdd cb dac dccd d a acdd d c cb b bcbb c a aca bcba d d bbdbc d c dabad ccca dc adb ddb dcdd dba ad ddaba c ac ddac bbbd cd a dacbb 1";
        // while ((inputStr = reader.readLine()) != null){
        String[] strArrays = inputStr.split(" ");
        int size = Integer.valueOf(strArrays[0]);
        System.out.println(size);
        String targetStr = strArrays[strArrays.length - 2];
        System.out.println(targetStr);
        int searchIndex = Integer.valueOf(strArrays[strArrays.length - 1]);
        System.out.println(searchIndex);
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= size; i++) {
            if (checkBrother(targetStr, strArrays[i])) {
                list.add(strArrays[i]);
            }
        }
        if (searchIndex <= list.size() && searchIndex > 0 && list.size() > 0) {
            System.out.println(list.size());
            Collections.sort(list);
            System.out.println(list.get(searchIndex - 1));
        }
        //}
    }

    private static boolean checkBrother(String targetStr, String strArray) {
        boolean brotherWord = false;
        if (targetStr.equals(strArray) == false && targetStr.length() == strArray.length()) {
            char[] targetChar = targetStr.toCharArray();
            char[] strChar = strArray.toCharArray();
            //int[] equalsSize = new  int[strArray.length()];
            char[] caseChar = new char[26];
            for (int i = 0; i < targetChar.length; i++) {
                caseChar[targetChar[i] - 'a']++;
                caseChar[strChar[i] - 'a']--;
            }
            for (int i = 0; i < 26; i++) {
                if (caseChar[i] != 0) {
                    return brotherWord;
                }
            }
            brotherWord = true;
        }
        return brotherWord;
    }
}
