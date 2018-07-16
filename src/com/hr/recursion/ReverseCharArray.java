package com.hr.recursion;

import java.util.Arrays;

public class ReverseCharArray {

	public static void main(String[] args) {

		char[] arr = { 'A' };

		int l = arr.length;

		int i = 0;

		while (i < l) {

			char temp = arr[l - 1];
			arr[l - 1] = arr[i];
			arr[i] = temp;
			i++;
			l--;
		}

		System.out.println(Arrays.toString(arr));

	}

}
