package com.example.demo.huaweicode;

import java.util.Scanner;

public class StringNumber {
	/**
	 * 计算目标字符出现在源字符串中的次数，不区分大小写
	 * @param sourceString
	 * @param targetString
	 * @return
	 */
	public static int calcatorCharNumber(String sourceString,String targetString) {
		char[] charArray = sourceString.toCharArray();
		int count= 0;
		for (int i = 0; i < charArray.length; i++) {
			if(targetString.equalsIgnoreCase(String.valueOf(charArray[i]))) {
				count ++;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入字符串：");
		String sourceString = scanner.nextLine();
		System.out.println("请输入字符：");
		String targetString = scanner.nextLine();
		if(targetString.length()>1) {
			System.out.println("您输入的不是字符");
			return;
		}	
		System.out.println("匹配次数："+calcatorCharNumber(sourceString, targetString));
	}

}
