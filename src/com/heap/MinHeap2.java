package com.heap;

public class MinHeap2 {

	private static int[] Heap;

	private int size;

	private int maxSize;

	public MinHeap2(int maxSize) {

		this.maxSize = maxSize;
		this.size = 0;
		Heap = new int[maxSize + 1];
		Heap[0] = Integer.MIN_VALUE;

	}

	public void insert(int elment) {

		Heap[++size] = elment;

		int current = size;

		while (Heap[current] < Heap[parent(current)]) {

			swap(current, parent(current));
		}

	}

	private int parent(int pos) {
		return pos / 2;
	}

	private static void swap(int fpos, int spos) {
		int tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}

	private int left(int i) {

		return 2 * i + 1;
	}

	private int right(int i) {

		return 2 * i + 2;
	}

	void minHeapify(int i) {

		int l = left(i);

		int r = right(i);

		int smallest = i;

		if (l < size && Heap[l] < Heap[i]) {
			smallest = l;
		}

		if (r < size && Heap[r] < Heap[smallest]) {
			smallest = r;
		}

		if (smallest != i) {
			swap(i, smallest);
			minHeapify(smallest);
		}

	}

	int extractMin() {

		int root = Heap[1];

		Heap[1] = Heap[size--];
		minHeapify(1);

		return root;
	}

	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(
					" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
			System.out.println();
		}
	}

	public void minHeap() {
		for (int pos = (size / 2); pos >= 1; pos--) {
			minHeapify(pos);
		}

	}

}
