package com.hr.recursion;

public class ArraySumWithoutLoop {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 31, 4, 5 };

		System.out.println(sum(arr, arr.length));

	}

	private static int sum(int[] arr, int n) {
		
		return sumRec(arr,0,n-1);
		
	}

	private static int sumRec(int[] arr, int i, int j) {
		
		if(i<=j) {
			
			return arr[i]+sumRec(arr, i+1, j);
		}
		
		return 0;
		
	}

}
