package com.example.demo.huaweicode;

import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

import org.junit.jupiter.api.Test;

public class IndexValueTest {

    @Test
    public void indexValue() {

        Scanner scanner = new Scanner(System.in);
        int times = Integer.valueOf(scanner.nextLine());
        TreeMap<Integer, Integer> hashMap = new TreeMap<>();
        for (int i = 0; i < times; i++) {
            String keyValue = scanner.nextLine();
            Integer key = Integer.valueOf(keyValue.substring(0, keyValue.indexOf(" ")));
            Integer value = Integer.valueOf(keyValue.substring(keyValue.indexOf(" ") + 1));
            if (hashMap.get(key) != null) {// 控制判断，处理key相等累加的数据
                hashMap.put(key, value + hashMap.get(key));
            } else {
                hashMap.put(key, value);
            }
        }
        Iterator<Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<Integer, Integer> next = iterator.next();// 获取键值对
            System.out.println(next.getKey() + " " + next.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int times = Integer.valueOf(scanner.nextLine());
        TreeMap<Integer, Integer> hashMap = new TreeMap<>();
        for (int i = 0; i < times; i++) {
            String keyValue = scanner.nextLine();
            Integer key = Integer.valueOf(keyValue.substring(0, keyValue.indexOf(" ")));
            Integer value = Integer.valueOf(keyValue.substring(keyValue.indexOf(" ") + 1));
            if (hashMap.get(key) != null) {// 控制判断，处理key相等累加的数据
                hashMap.put(key, value + hashMap.get(key));
            } else {
                hashMap.put(key, value);
            }
        }
        Iterator<Entry<Integer, Integer>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Entry<Integer, Integer> next = iterator.next();// 获取键值对
            System.out.println(next.getKey() + " " + next.getValue());
        }
    }

}
