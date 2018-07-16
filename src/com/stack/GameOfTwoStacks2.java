package com.stack;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class GameOfTwoStacks2 {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		// BufferedWriter bufferedWriter = new BufferedWriter(new
		// FileWriter(System.getenv("OUTPUT_PATH")));

		int g = Integer.parseInt(scanner.nextLine().trim());

		for (int gItr = 0; gItr < g; gItr++) {
			String[] nmx = scanner.nextLine().split(" ");

			int n = Integer.parseInt(nmx[0].trim());

			int m = Integer.parseInt(nmx[1].trim());

			int x = Integer.parseInt(nmx[2].trim());

			int[] a = new int[n];

			String[] aItems = scanner.nextLine().split(" ");

			for (int aItr = 0; aItr < n; aItr++) {
				int aItem = Integer.parseInt(aItems[aItr].trim());
				a[aItr] = aItem;
			}

			int[] b = new int[m];

			String[] bItems = scanner.nextLine().split(" ");

			for (int bItr = 0; bItr < m; bItr++) {
				int bItem = Integer.parseInt(bItems[bItr].trim());
				b[bItr] = bItem;
			}

			int result = twoStacks(x, a, b);

			System.out.println(result);

			// bufferedWriter.write(String.valueOf(result));
			// bufferedWriter.newLine();
		}

		scanner.close();
		// bufferedWriter.close();
	}

	static int twoStacks(int x, int[] h1, int[] h2) {

		int sum = 0;
		int i = 0;

		Stack<Integer> a1 = new Stack<Integer>();
		Stack<Integer> b1 = new Stack<Integer>();

		for (i = 0; i < h1.length; i++) {

			sum = sum + h1[i];

			if (sum > x) {
				sum = sum - h1[i];
				break;
			}

			a1.push(h1[i]);

		}

		for (int j = h2.length - 1; j >= 0; j--) {
			b1.push(h2[j]);
		}

		int j = 0;
		int count = 0;

		while (j < h2.length && i >= 0) {

			while (sum > x && i > 0) {
				sum = sum - a1.pop();
				i--;
			}

			if (count < (i + j) && sum <= x) {
				count = i + j;
			}
			sum = sum + b1.pop();
			j++;
			while (sum > x && i > 0) {
				sum = sum - a1.pop();
				i--;
			}
			if (count < (i + j) && sum <= x) {
				count = i + j;
			}

		}
		return count;

	}

}
