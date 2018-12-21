package com.test.logic_test.task2;

import java.util.Arrays;
import java.util.Scanner;

public class Task2 {
	
    public static void main(String[] args) 
    { 
        
        @SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		
		System.out.printf("Enter length of array : ");
		int maxArray = scan.nextInt();
		
		int valueOfArray[] = new int[maxArray];
		
		for (int i = 0; i < valueOfArray.length; i++) {
			System.out.printf("Enter value of array " + (i+1) + " : ");
			valueOfArray[i] = scan.nextInt();
		}
		
		System.out.println("Array : " + Arrays.toString(valueOfArray));
		
        maxSubArraySum(valueOfArray, maxArray); 
    } 
    
	public static void maxSubArraySum(int valueOfArray[], int size) 
    { 
        int max_so_far = Integer.MIN_VALUE, 
        max_ending_here = 0,start = 0, 
        end = 0, s = 0;
        int tempEnd = 0;
        int tempStart = 0;
        int j = 0;
    
        for (int i = 0; i < size; i++)  
        { 
            max_ending_here += valueOfArray[i]; 
  
            if (max_so_far < max_ending_here)  
            { 
                max_so_far = max_ending_here; 
                start = s; 
                end = i; 
            } 
  
            if (max_ending_here < 0)  
            { 
                max_ending_here = 0; 
                s = i + 1; 
            }
            
        }
        
        tempEnd = end - 1;
        tempStart = start;
        int output[] = new int[tempEnd];
        
		for (j = 0; j < tempEnd; j++) {
			output[j] = valueOfArray[tempStart];
			tempStart = tempStart + 1;
		}
        System.out.println("Output : " + Arrays.toString(output));
    }
}
  

