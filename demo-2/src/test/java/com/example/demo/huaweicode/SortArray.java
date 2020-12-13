package com.example.demo.huaweicode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

public class SortArray {
	public static volatile boolean stopInput = true;
	
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		Set<Integer> setArray = new TreeSet<>();
		String sizeStr;
			while ((sizeStr = reader.readLine()) !=null) {
				Integer size = Integer.valueOf(sizeStr);
				for (int i = 0; i < size; i++) {
					String nextLine = reader.readLine();
					setArray.add(Integer.valueOf(nextLine));
				}
			}			
		setArray.stream().sorted().forEach(System.out::println);
	}
	
	@Test
	public void sortArrayTest() {
		Scanner scanner = new Scanner(System.in);
		Set<Integer> setArray = new TreeSet<>();
		String pattern = "^-?[1-9]\\d*$";
			while (stopInput) {
				String sizeStr = scanner.nextLine();
				boolean matchSize = Pattern.matches(pattern, sizeStr);
				if(!matchSize) {
					 stopInput = false;
					 break;
				}
				Integer size = Integer.valueOf(sizeStr);
				//System.out.println(size);
				for (int i = 0; i < size; i++) {
					String nextLine = scanner.nextLine();
					 boolean matches = Pattern.matches(pattern, nextLine);
					 if(matches) {
						setArray.add(Integer.valueOf(nextLine));
						//System.out.println(nextLine);
					 }
				}
			}			
		setArray.stream().sorted().forEach(System.out::println);
		scanner.close();	
	}

	
}
