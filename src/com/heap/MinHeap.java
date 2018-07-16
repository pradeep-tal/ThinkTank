package com.heap;

public class MinHeap {

	static int[] h;

	static int size = 0;

	public static void main(String[] args) {

		int arr[] = { 1, 1, 1 };

		System.out.println(cookies(10, arr));

	}

	static int cookies(int k, int[] A) {

		h = new int[A.length + 1];

		for (int i = 0; i < A.length; i++) {
			insert(A[i]);
		}

		minHeap();

		int op = 0;

		int it = size - 1;

		int v1 = extractMin();

		while (v1 < k && it > 0) {

			it--;

			op++;

			int v2 = extractMin();

			int sweetNess = v1 * 1 + v2 * 2;

			insert(sweetNess);

			minHeap();

			v1 = extractMin();

		}

		return (v1 >= k) ? op : -1;

	}

	private static void minHeap() {
		int i = (size - 1) / 2;

		while (i >= 0) {
			minHeapify(i);
			i--;
		}

	}

	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(" PARENT : " + h[i] + " LEFT CHILD : " + h[left(i)] + " RIGHT CHILD :" + h[right(i)]);
			System.out.println();
		}
	}

	private static void insert(int elment) {

		int current = size;

		h[current] = elment;

		while (h[current] < h[parent(current)]) {

			swap(current, parent(current));
		}

		size = size + 1;

	}

	private static void delete(int element) {

		int i = 0;

		for (i = 0; i < size; i++) {
			if (h[i] == element) {

				break;
			}
		}

		h[i] = h[size];

		size = size - 1;

		minHeapify(i);

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

	private static int extractMin() {

		if (size == 0) {
			return -1;
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

}
