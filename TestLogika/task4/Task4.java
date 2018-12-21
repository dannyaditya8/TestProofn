package com.test.logic_test.task4;

import java.util.Arrays;

public class Task4 {
	
	static long countWays(int sum[], int m, int n) 
    { 
        
		long[] notes = new long[n+1]; 
   
        Arrays.fill(notes, 0);
   
        notes[0] = 1; 
   
        for (int i=0; i<m; i++) 
            for (int j=sum[i]; j<=n; j++) 
                notes[j] += notes[j-sum[i]]; 
  
        return notes[n]; 
    } 
   
    public static void main(String args[]) 
    { 
        int arr[] = {2, 5, 9}; 
        int m = arr.length; 
        int n = 4; 
        System.out.println(countWays(arr, m, n)); 
    } 
} 
