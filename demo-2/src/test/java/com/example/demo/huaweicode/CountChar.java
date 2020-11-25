package com.example.demo.huaweicode;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

import org.junit.jupiter.api.Test;

public class CountChar {
	
	@Test
	public void countChar() {
		Scanner scanner = new Scanner(System.in);
		String charStr = scanner.nextLine();
		char[] charArray = charStr.toCharArray();
		Set<String> setStr = new HashSet<>();
		for (int i = 0; i < charArray.length; i++) {
			setStr.add(String.valueOf(charArray[i]));
		}
		System.out.println(setStr.size());
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String charStr = scanner.nextLine();
		char[] charArray = charStr.toCharArray();
		Set<String> setStr = new HashSet<>();
		for (int i = 0; i < charArray.length; i++) {
			setStr.add(String.valueOf(charArray[i]));
		}
		System.out.println(setStr.size());
	}

}
