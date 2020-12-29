package com.example.demo.huaweicode;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class DeleteMinChar {

    public static void main(String[] args) throws IOException {
        //删除字符串中出现次数最少的字符
        //Java 是面向对象的语言，是否可以将处理的数据抽离出来设计为对象CharSize,两个field:charName,size
        //step1 转换：将字符串转换为字符串List,CharSize的List
        //step2 排重：通过stream来排重，比较前后的大小判断是否需要进行删除字符处理
        //step3 计算：计算去重字符出现的次数
        //step4 收集：收集出现最小次数的字符，通过stream的filter和collect
        //step5 删除：通过Iterator删除step4收集的字符
        //step6 转换：将处理后的List通过stream中的Collectors.joining()拼接为字符串
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = "";
        List<String> result = new ArrayList<>();
        while ((inputString = reader.readLine()) != null) {
            //step2 将字符串通过toChar()转换为字符数组，数组转换为stream，通过distinct()去重后，count()获取排重后
            // 获取字符数组大小numberOfDistinct
            List<CharSize> charList = new ArrayList<>();
            List<String> charStrList = new ArrayList<>();
            int size = inputString.length();
            if (size > 0 && size <= 20) {
                char[] charArrays = inputString.toCharArray();
                for (int i = 0; i < size; i++) {
                    charList.add(new CharSize(String.valueOf(charArrays[i])));
                    charStrList.add(String.valueOf(charArrays[i]));
                }
                List<CharSize> distinctList = charList.stream().distinct().collect(Collectors.toList());
                for (CharSize distinctStr : distinctList) {
                    for (CharSize charStr : charList) {
                        if (distinctStr.getCharName().equals(charStr.getCharName())) {
                            distinctStr.setSize((distinctStr.getSize()) + 1);
                        }
                    }
                }
                CharSize minChar = distinctList.stream().min((x, y) -> x.getSize() - y.getSize()).get();
                int min = minChar.getSize();
                List<String> minCharList = distinctList.stream().filter(s -> s.size == min).map(s -> s.getCharName()).collect(Collectors.toList());
                Iterator iterable = charStrList.iterator();
                while (iterable.hasNext()) {
                    if (minCharList.contains(iterable.next())) {
                        iterable.remove();
                    }
                }
                result.add(charStrList.stream().collect(Collectors.joining()));
            }
        }
        result.stream().forEach(System.out::println);
    }

    @Test
    public void deleteMinCharTest() throws IOException {
        //删除字符串中出现次数最少的字符
        //时间顺序，进行任务分解，接收字符串，计算字符串中字符出现的次数，找出出现次数最少的字符，进行过滤或者删除
        //Java 是面向对象的语言，是否可以将处理的数据抽离出来设计为对象CharSize,两个field:charName,size
        //step1 转换：将字符串转换为字符串List,CharSize的List
        //step2 排重：通过stream来排重，比较前后的大小判断是否需要进行删除字符处理
        //step3 计算：计算去重字符出现的次数
        //step4 收集：收集出现最小次数的字符，通过stream的filter和collect
        //step5 删除：通过Iterator删除step4收集的字符
        //step6 转换：将处理后的List通过stream中的Collectors.joining()拼接为字符串
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = "";
        List<String> result = new ArrayList<>();
        while ((inputString = reader.readLine()) != null) {
            List<CharSize> charList = new ArrayList<>();
            List<String> charStrList = new ArrayList<>();
            int size = inputString.length();
            char[] charArrays = inputString.toCharArray();
            if (size > 0 && size <= 20) {
                //将字符数组转换为字符串List集合和CharSize的List集合
                for (int i = 0; i < size; i++) {
                    charList.add(new CharSize(String.valueOf(charArrays[i])));
                    charStrList.add(String.valueOf(charArrays[i]));
                }
                //通过stream对字符排重
                List<CharSize> distinctList = charList.stream().distinct().collect(Collectors.toList());
                //如果排重字符数值小于原字符长度，才进行删除处理，否则返回原字符串
                if (distinctList.size() < charList.size()) {
                    //
                    for (CharSize distinctStr : distinctList) {
                        for (CharSize charStr : charList) {
                            if (distinctStr.getCharName().equals(charStr.getCharName())) {
                                distinctStr.setSize((distinctStr.getSize()) + 1);
                            }
                        }
                    }
                    CharSize minChar = distinctList.stream().min((x, y) -> x.getSize() - y.getSize()).get();
                    int min = minChar.size;
                    List<String> minCharList = distinctList.stream().filter(s -> s.size == min).map(s -> s.getCharName()).collect(Collectors.toList());
                    Iterator iterable = charStrList.iterator();
                    while (iterable.hasNext()) {
                        if (minCharList.contains(iterable.next())) {
                            iterable.remove();
                        }
                    }
                    result.add(charStrList.stream().collect(Collectors.joining()));
                } else {
                    result.add(inputString);
                }
            }
        }
        result.stream().forEach(System.out::println);
    }

    /**
     * 字符和出现次数对应关系类
     */
    static class CharSize {
        public String charName;

        public int size;

        public String getCharName() {
            return charName;
        }

        public CharSize(String charName) {
            this.charName = charName;
        }

        public CharSize(String charName, int size) {
            this.charName = charName;
            this.size = size;
        }

        public CharSize() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            CharSize charSize = (CharSize) o;
            return Objects.equals(charName, charSize.charName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(charName);
        }

        public void setCharName(String charName) {
            this.charName = charName;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }
    }
}
