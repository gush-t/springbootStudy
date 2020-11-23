package com.example.demo.huaweicode;

import java.math.BigInteger;
import java.util.Scanner;

import org.junit.jupiter.api.Test;


public class HexBinDecOct {
	
	@Test
	public void hexBinTest() {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String string = (String) scanner.nextLine();
			if(string.equals("")==false) {
				System.out.println(new BigInteger(string, 16).toString(10));
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String string = (String) scanner.nextLine();
			if(string.equals("")==false) {
				System.out.println(new BigInteger(string.substring(2), 16).toString(10));
			}
		}
	}
}
