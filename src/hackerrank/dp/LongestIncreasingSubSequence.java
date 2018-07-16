package hackerrank.dp;

import java.util.Arrays;

import util.Utils;

public class LongestIncreasingSubSequence {

	public static void main(String args[]) {

		int[] arr = { 9, 7, 8 ,11, 0, 10, 22, 33 };

		lis(arr);

		lics(arr);
	}

	private static void lics(int[] arr) {

		int n = arr.length;

		int[] lis = new int[n];

		Arrays.fill(lis, 1);

		for (int i = 1; i < n; i++) {

			int j = i - 1;

			if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {

				lis[i] = lis[j] + 1;
			}

		}

		Utils.printArray(lis, n);

	}

	private static void lis(int[] arr) {

		int n = arr.length;

		int[] lis = new int[n];

		Arrays.fill(lis, 1);

		for (int i = 1; i < n; i++) {

			for (int j = 0; j < i; j++) {

				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {

					lis[i] = lis[j] + 1;
				}

			}
		}

		Utils.printArray(lis, n);

	}

}
