package com.heap;

public class BuildMinHeap {

	int size = 0;

	public static void main(String args[]) {


		MinHeap2 minHeap = new MinHeap2(10);

		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(17);
		minHeap.insert(10);
		minHeap.insert(84);
		minHeap.insert(19);
		minHeap.insert(6);
		minHeap.insert(22);
		minHeap.insert(9);
		
		minHeap.print();
		
		minHeap.minHeap();
		
		System.out.println(minHeap.extractMin());
		
		System.out.println(minHeap.extractMin());
		
	}

}
