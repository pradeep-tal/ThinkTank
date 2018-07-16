package com.test;

import java.util.Scanner;

import util.Utils;

public class RunningMedian {

	static int[] h;

	static int[] hs;

	static int size = 0;

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] a = new int[n];
		
		
		for (int a_i = 0; a_i < n; a_i++) {
			a[a_i]=in.nextInt();
		}
		
	/*	h=a;
		size=n;
		
		buildHeap(n);
		
		Utils.printArray(h, size);*/
		
		h=new int[n];
		
		size=0;
		
		hs=new int[n];

		for(int i=0;i<n;i++) {
			Utils.printArray(hs, size);
			insertKey(a[i]);
			Utils.printArray(hs, size);
			heapSort(hs);
		}
		
		//Utils.printArray(h, size);
		Utils.printArray(hs, size);

		in.close();

	}

	private static void heapSort(int[] arr) {
		
		
		
		for(int i=size-1;i>=0;i--) {
			
			int temp=arr[i];
			arr[i]=arr[0];
			arr[0]=temp;
			
			heapify(arr,0, i);
		}
		
		Utils.printArray(arr, size);
		
	}

	private static void buildHeap(int n) {

		int i = (n - 1) / 2;

		while (i >= 0) {
			heapify(h,i,n);
			i--;
		}

	}

	static void insertKey(int k) {

		size = size + 1;

		int i = size - 1;
		
		hs[i]=k;

		while (i != 0 && hs[parent(i)]  < hs[i]) {

			swap(parent(i), i);

			i = parent(i);
		}

	}

	private static void heapify(int[] h, int i,int n) {

		int l = left(i);

		int r = right(i);

		int largest = i;

		if (l < n && h[l] > h[i]) {
			largest = l;
		}

		if (r < n && h[r] > h[largest]) {
			largest = r;
		}

		if (largest != i) {
			swap(i, largest);
			heapify(h,largest,n);
		}

	}

	static int getMedian() {

		if (size % 2 == 0) {

			int mid = size / 2;

			return (h[mid] + h[mid - 1]) / 2;

		} else {
			int mid = (size - 1) / 2;
			return h[mid];
		}

	}

	private static int left(int i) {

		return 2 * i + 1;
	}

	private static int right(int i) {

		return 2 * i + 2;
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
