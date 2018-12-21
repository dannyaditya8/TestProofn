package com.test.logic_test.task1;

import java.util.Arrays;
import java.util.Scanner;

public class Task1 {
	public static void main(String args[])
	{
		
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("Enter length of array: ");
		int numOfArray = scan.nextInt();
		
		int valueOfArray[] = new int[numOfArray];
		
		for (int i = 0; i < valueOfArray.length; i++) {
			System.out.printf("Enter value of array " + (i+1) + " : ");
			valueOfArray[i] = scan.nextInt();
			
		}
		
		System.out.println("Array : " + Arrays.toString(valueOfArray));
		
		System.out.printf("X : ");
		int sum = scan.nextInt();
		
		getPairsCount(valueOfArray, sum);
	}
	
	public static void getPairsCount(int[] arr, int sum) {
		
		int count = 0;
		Boolean output = null;
		
		for(int i=0; i < arr.length; i++) {
			for(int j=i+1; j < arr.length; j++) {
				if ((arr[i] + arr[j]) == sum) {
					System.out.printf("Because %d + %d \n", arr[i], arr[j]);
					count++;
				} else if (count > 0) {
					output = true;
				} else {
					output = false;
				}
			}
		}
		if (output) {
			System.out.printf("Output : %b (Pairs with X : %d)", output, count);
		} else {
			System.out.printf("Output : %b (Pairs not found with X)", output);
		}
		
	}


}
