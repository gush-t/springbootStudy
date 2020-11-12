package com.example.demo.huaweicode;

import java.util.Scanner;

import org.junit.jupiter.api.Test;

public class StringEight {
	
	@Test
	public void subStringEight() {
		Scanner scanner = new Scanner(System.in);
		String oneStr = scanner.nextLine();
		String twoStr = scanner.nextLine();
		
		if(oneStr.length()<=8) {
			outPut(oneStr);
			if(twoStr.length()<=8) {
				outPut(twoStr);				
			}else {
				outPutGreaterThanEight(twoStr);
			}
		}else {
			int length = oneStr.length();
			int size = length/8;
			int remainder = length%8;
			for (int i = 0; i < size; i++) {
				System.out.println(oneStr.substring(i*8, (i+1)*8));
			}
			if(remainder != 0) {
				String remainderOneStr = oneStr.substring(size*8);
				remainderOneStr = remainderOneStr+twoStr;
				outPutGreaterThanEight(remainderOneStr);
			}
		}
	}
	
	/**
	 * 字符串小于8的，补0处理
	 * @param str
	 */
	public static void outPut(String str) {
		StringBuilder oneStrBuilder = new StringBuilder(); 
		oneStrBuilder.append(str);
		for (int i = 0; i < 8-str.length(); i++) {
			oneStrBuilder.append("0");
		}
		System.out.println(oneStrBuilder.toString());
	}
	
	/**
	 * 第二个字符串长度大于8的处理
	 * @param str
	 */
	public static void outPutGreaterThanEight(String twoStr) {
		int length = twoStr.length();
		int size = length/8;
		int remainder = length%8;
		for (int i = 0; i < size; i++) {
			System.out.println(twoStr.substring(i*8, (i+1)*8));
		}
		if(remainder != 0) {
			outPut(twoStr.substring(size*8));
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String oneStr = scanner.nextLine();
		String twoStr = scanner.nextLine();
		if(oneStr.length()<=8) {
			outPut(oneStr);
			if(twoStr.length()<=8) {
				outPut(twoStr);				
			}else {
				outPutGreaterThanEight(twoStr);
			}
		}else {
			int length = oneStr.length();
			int size = length/8;
			int remainder = length%8;
			for (int i = 0; i < size; i++) {
				System.out.println(oneStr.substring(i*8, (i+1)*8));
			}
			if(remainder != 0) {
				String remainderOneStr = oneStr.substring(size*8);
				remainderOneStr = remainderOneStr+twoStr;
				outPutGreaterThanEight(remainderOneStr);
			}
		}
	}
	
	@Test
	public void test() {
		String str1 = "urivthvtlqqerctlxmjvkgvfclaaduwmaadedpadanl";
		String str = "batkqdhjnrwtsmzidswdnenqpsblsszldyttytrgenaizwehntqiaaufble";
		System.out.println(str.length());
		System.out.println(str1.length());
	}

}
