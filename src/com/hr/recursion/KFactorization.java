package com.hr.recursion;

import java.util.Arrays;
import java.util.Comparator;

public class KFactorization {

	static int fSum = -1;

	static String fExp = "";

	public static void main(String[] args) {

		Integer[] A = { 2, 3, 4 };
		
		Arrays.sort(A, new Comparator<Integer>() {
		    @Override
		    public int compare(Integer o1, Integer o2) {
		        return Integer.compare(o2, o1);
		    }
		});

		for(int i=0;i<A.length;i++) {
			
			System.out.println(A[i]);
		}
		
		
		int n = 12;

		kFactRec(1, n, A, 1, "1");

	}

	private static void kFactRec(int start, int n, Integer[] a, int sum, String exp) {

		for (int k = 0; k < a.length; k++) {

			int next = start * a[k];

			System.out.println(next);

			exp = exp + "->" + next;

			sum = sum + next;

			if (next == 12) {

				if (sum > fSum) {
					fSum = sum;
					fExp = exp;
				}
				
				System.out.println(exp);

			} else if (next < n / 2) {

				kFactRec(next, n, a, sum, exp);

			}

		}

	}
	
	static class Sort implements Comparator<Integer> {

		@Override
		public int compare(Integer o1, Integer o2) {
			return o1.compareTo(o1);
		}
		
	}

}
