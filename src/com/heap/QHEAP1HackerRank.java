package com.heap;

import java.util.Scanner;

public class QHEAP1HackerRank {

	static int[] h = new int[100000];

	static int size = 0;

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int testCases = Integer.parseInt(scanner.nextLine());

		for (int i = 0; i < testCases; i++) {

			String[] input = scanner.nextLine().trim().split(" ");

			int operation = Integer.parseInt(input[0]);

			if (operation == 1) {
				int val = Integer.parseInt(input[1]);
				insert(val);
			} else if (operation == 2) {
				int val = Integer.parseInt(input[1]);
				delete(val);
			} else {
				printMin();
			}

		}

		scanner.close();

	}

	private static void printMin() {

		if (size >= 0) {

			System.out.println(h[0]);

		}

	}



	private static void insert(int elment) {

		size = size + 1;

		int current = size - 1;

		h[current] = elment;

		while (current != 0 && h[current] < h[parent(current)]) {

			swap(current, parent(current));
			current = parent(current);
		}


	}

	private static void delete(int element) {

		int i = 0;

		for (i = 0; i < size; i++) {
			if (h[i] == element) {

				break;
			}
		}

		h[i] = h[size - 1];

		size = size - 1;

		if (size > 1) {

			minHeapify(i);
		}

	}

	private static void minHeapify(int i) {

		int l = left(i);

		int r = right(i);

		int smallest = i;

		if (l < size && h[l] < h[i]) {
			smallest = l;
		}

		if (r < size && h[r] < h[smallest]) {
			smallest = r;
		}

		if (smallest != i) {
			swap(i, smallest);
			minHeapify(smallest);
		}

	}

	private static void swap(int i, int smallest) {

		int temp = h[i];
		h[i] = h[smallest];
		h[smallest] = temp;

	}

	private static int parent(int i) {

		return (i - 1) / 2;
	}

	private static int left(int i) {

		return 2 * i + 1;
	}

	private static int right(int i) {

		return 2 * i + 2;
	}

}
