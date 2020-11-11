package com.example.demo.threadpool;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Stack;

import org.junit.jupiter.api.Test;

public class TestThreadPool {

	ThreadLocal<String> name = ThreadLocal.withInitial(() -> {
		return "nihao";
	});

	@Test
	public void threadTest() {
		Thread threadOne = new Thread(() -> System.out.println("nihao"));
		String a = "sdfsdfsdfssdfs";
		String d = a.toUpperCase();
		String number = "123";
		String b = number.toUpperCase();
		System.out.println(b);
		System.out.println(d);
		char c = 's';
		char[] charArray = a.toCharArray();
		int count = 0;
		for (int i = 0; i < charArray.length; i++) {
			if (c == charArray[i]) {
				count++;
			}
		}
		assertThat(6).isEqualTo(count);
	}
	
	@Test
	public void selectCharNumber() {
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
	
	public void StackTest() {
		Stack<String> stack = new Stack<>();
		stack.push("gushaohua");
		stack.push("gushaohua02");
		stack.push("gushaohua03");
		Iterator<String> iterator = stack.iterator();
		while (iterator.hasNext()) {
			String string = (String) iterator.next();
			System.out.println(stack.peek());
			System.out.println(stack.pop());
		}
	}
}
