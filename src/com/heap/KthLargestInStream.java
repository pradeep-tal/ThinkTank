package com.heap;

import java.util.Scanner;

public class KthLargestInStream {

	static int size = 0;

	static int[] h;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int k = in.nextInt();
		h = new int[k];

		while (true) {

			int elem = in.nextInt();

			if (size < k - 1) {
				h[size++] = elem;
			} else if (size == k - 1) {
				h[size++] = elem;
				buildHeap(size);
			}else
			{
				if(elem > h[0]) {
					
					h[0]=elem;
					heapify(h, 0, size);
				}
				
			}

			System.out.println(h[0]);
		}

	}

	private static void buildHeap(int n) {

		int i = (n - 1) / 2;

		while (i >= 0) {
			heapify(h, i, n);
			i--;
		}

	}

	private static void heapify(int[] h, int i, int n) {

		int l = left(i);

		int r = right(i);

		int largest = i;

		if (l < n && h[l] < h[i]) {
			largest = l;
		}

		if (r < n && h[r] < h[largest]) {
			largest = r;
		}

		if (largest != i) {
			swap(i, largest);
			heapify(h, largest, n);
		}

	}

	private static int left(int i) {

		return 2 * i + 1;
	}

	private static int right(int i) {

		return 2 * i + 2;
	}

	static void insertKey(int elm, int k) {

		size = size + 1;

		int i = Math.min(size - 1, k);

		h[i] = elm;

		while (i != 0 && h[parent(i)] > h[i]) {

			swap(parent(i), i);

			i = parent(i);
		}

	}

	private static void swap(int parent, int i) {

		int temp = h[parent];
		h[parent] = h[i];
		h[i] = temp;

	}

	static int parent(int i) {
		return (i - 1) / 2;
	}

}
