package com.example.demo.huaweicode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.jupiter.api.Test;

public class PrimeFactor {
	
	@Test
	public void testPrimeFactor() {
		BufferedReader buffer = new BufferedReader( new InputStreamReader(System.in));
		String inputStr;
		StringBuilder sb = new StringBuilder();
		try {
			while((  inputStr = buffer.readLine()) == null) {
				int inputNumber = Integer.valueOf(inputStr);
				for (int i = 2; i < Math.sqrt(inputNumber); i++) {
					if(inputNumber % i == 0) {
						sb.append(i+" ");//获取除数
						inputNumber/=i; //获取商
						i--;
					}
				}
				sb.append(inputNumber+" ");
				System.out.println(sb.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	public static void main(String[] args) {
		BufferedReader buffer = new BufferedReader( new InputStreamReader(System.in));
		String inputStr;
		StringBuilder sb = new StringBuilder();
		try {
			while((  inputStr = buffer.readLine()) != null) {
				int inputNumber = Integer.valueOf(inputStr);
				for (int i = 2; i < Math.sqrt(inputNumber); i++) {
					if(inputNumber % i == 0) {
						sb.append(i+" ");//获取除数
						inputNumber/=i; //获取商
						i--;
					}
				}
				sb.append(inputNumber+" ");
				System.out.println(sb.toString());
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
