package com.example.demo.huaweicode;

import java.util.LinkedHashSet;
import java.util.Scanner;

import org.junit.jupiter.api.Test;
import org.springframework.core.io.support.SpringFactoriesLoader;

public class ReserveNumber {
	
	@Test
	public void reserveNumber() {
		Scanner scanner = new Scanner(System.in);
		String numberStr = scanner.nextLine();
		char[] charArray = numberStr.toCharArray();
		LinkedHashSet<String> numberLinkedSet = new LinkedHashSet<>();
		for (int i = charArray.length; i >0 ; i--) {
			numberLinkedSet.add(String.valueOf(charArray[i-1]));
		}
		StringBuffer strBuffer = new StringBuffer();
		for (String string : numberLinkedSet) {
			strBuffer.append(string);
		}
		System.out.println(strBuffer.toString());
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String numberStr = scanner.nextLine();
		char[] charArray = numberStr.toCharArray();
		LinkedHashSet<String> numberLinkedSet = new LinkedHashSet<>();
		for (int i = charArray.length; i >0 ; i--) {
			numberLinkedSet.add(String.valueOf(charArray[i-1]));
		}
		numberLinkedSet.stream().forEach(System.out::print);
	}
}
