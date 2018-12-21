package com.test.logic_test.task3;

import java.util.Scanner;

public class Task3 {
	
	public static void main(String args[]) {
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("Enter dividend : ");
		int dividend = scan.nextInt();
		
		System.out.printf("Enter divisor : ");
		int divisor = scan.nextInt();
		
		divide(dividend, divisor);
	}
	
	public static void divide(int dividend, int divisor) {
		
		int quotient = 0;
		
		while (dividend >= divisor) {
			dividend = dividend - divisor;
			quotient++;
		}
		
		System.out.println("Quotient is " + quotient);
		System.out.println("Remainder is " + dividend);
	}

}
