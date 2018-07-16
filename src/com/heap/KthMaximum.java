package com.heap;

public class KthMaximum {

	public static void main(String[] args) {
		int[] arr = { 1, 7, 3, 9, 10, 2 };

		sortArray(arr);

	}

	private static void sortArray(int[] arr) {

		int n = arr.length;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {

				if (arr[j] > arr[j + 1]) {
					
					int temp = arr[j];

					arr[j] = arr[j + 1];
					arr[j + 1] = temp;

				}
			}
		}

		int k=2;
		
		for (int i = 0; i < n; i++) {
			
			if(i==k) {
				System.out.println(arr[i]);
			}
		}

	}

}
