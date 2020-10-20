package com.example.demo.testJMM;

import org.junit.jupiter.api.Test;

public class TestJavaMemoryModel {
	
	private static volatile int autoInt =0;
	
	private static final int THREAD_COUNT = 20;
	
	public int increase() {
		System.out.println(autoInt++);
		return 0;
	}
	
	@Test
	public void testVolatile() {
		Thread[] threads = new Thread[THREAD_COUNT];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new Thread(() -> increase());
			threads[i].start();
			System.out.println(threads[i].getState());
			System.out.println(threads[i].getPriority());
			
		}
		System.out.println(threads[0].getState());
		
	}

	
}
