package com.example.demo.util;

public class CaculatorUtil {
	
	public static Double caculator(Double nubOne,Double nubTwo,String operate) {
		Double strResult = 0d;
		switch (operate) {
		case "+":
			strResult = nubOne + nubTwo;
			break;
		case "-":
			strResult = nubOne - nubTwo;
			break;
		case "/":
			strResult = nubOne / nubTwo;
			break;
		case "*":
			strResult = nubOne * nubTwo;
			break;

		default:
			break;
		}		
		return strResult;
		
		
	}

}