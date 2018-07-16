package com.heap;

import java.util.PriorityQueue;

public class JesseAndCookies {

	public static void main(String[] args) {

		int arr[] = { 1, 1, 1 };

		System.out.println(cookies(2, arr));

	}

	private static int cookies(int k, int[] arr) {

		PriorityQueue<Integer> q = new PriorityQueue<>();

		for (int i = 0; i < arr.length; i++) {
			q.add(arr[i]);
		}

		int v1 = q.poll();

		int op = 0;

		while (!q.isEmpty() && q.size() >= 1 && v1 < k) {

			int v2 = q.poll();

			q.add(v1 * 1 + v2 * 2);

			v1 = q.poll();

			op++;

		}

		return v1>=k ? op :-1;
	}

}
