package com.heap;

import util.Utils;

public class MinHeapInsert {



	static int[] h;

	static int size = 0;

	public static void main(String[] args) {

		h = new int[100];

		size = 0;
		
		insertKey(12);

		insertKey(4);

		insertKey(5);

		insertKey(3);

		insertKey(8);

		Utils.printArray(h,size);

		System.out.println(getMin());

		for (int k = 0; k < 2; k++) {

			System.out.println(extractMin());
		}
		
		Utils.printArray(h,size);

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

	private static void insertKey(int k) {

		size = size + 1;

		int i = size - 1;
		h[i] = k;

		while (i != 0 && h[parent(i)] > h[i]) {

			swap(parent(i), i);
			i = parent(i);

		}

	}

	private static int extractMin() {

		if (size == 0) {
			return Integer.MAX_VALUE;
		}

		int root = h[0];

		if (size > 1) {
			h[0] = h[size - 1];
			minHeapify(0);

		}

		size = size - 1;

		return root;
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

	private static int getMin() {

		return h[0];
	}


}
