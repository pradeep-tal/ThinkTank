package com.heap;

import util.Utils;

public class MaxHeap {
	
	static int[] h;

	static int size = 0;

	public static void main(String[] args) {

		int arr[] = { 3, 1, 6, 5, 8, 9 };

		h = arr;

		size = arr.length;

		int i = (size) / 2;

		while (i >= 0) {
			maxHeapify(i);
			i--;
		}

		Utils.printArray(h,size);

		System.out.println(getMax());
		
		for(int k =0;k<2;k++) {
			
			System.out.println(extractMax());
		}

	}

	private static void maxHeapify(int i) {

		int l = left(i);

		int r = right(i);

		int largest = i;

		if (l < size && h[l] > h[i]) {
			largest = l;
		}

		if (r < size && h[r] > h[largest]) {
			largest = r;
		}

		if (largest != i) {
			swap(i, largest);
			maxHeapify(largest);
		}

	}
	

	private static void swap(int i, int largest) {

		int temp = h[i];
		h[i] = h[largest];
		h[largest] = temp;

	}

	private static int extractMax() {

		if (size == 0) {
			return Integer.MAX_VALUE;
		}

		int root = h[0];

		if (size > 1) {
			h[0] = h[size - 1];
			maxHeapify(0);

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

	private static int getMax() {

		return h[0];
	}



}
