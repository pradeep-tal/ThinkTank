package com.hr.recursion;

public class ThePowerSum {

	private static int res;

	public static void main(String[] args) {

		int x = 10;
		int n = 2;

		check(x, n);

	}

	private static void check(int x, int n) {

		checkRecursive(x, 0, n, x);
		
		System.out.println(res);

	}

	private static void checkRecursive(int num, int k, int n, int remain) {

		int r = (int) Math.floor(Math.pow(num, (1.0 / n)));

		if (remain == 0) {
			res++;
		}

		for (int i = k + 1; i <= r; i++) {

			int a = remain-(int) Math.pow(i, n);

			if (a >= 0) {
				checkRecursive(num, i, n, a);
			}
		}

	}

}
