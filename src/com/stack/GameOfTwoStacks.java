package com.stack;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

public class GameOfTwoStacks {

	static int twoStacks(int x, int[] h1, int[] h2) {

		Stack<Integer> s1 = new Stack<>();

		Stack<Integer> s2 = new Stack<>();

		int sum1 = 0;

		for (int i = h1.length - 1; i >= 0; i--) {

			s1.push(h1[i]);

			sum1 = sum1 + h1[i];
		}

		for (int i = h2.length - 1; i >= 0; i--) {

			s2.push(h2[i]);
		}

		int moves = s1.size();
		
		int sumTillNow = sum1;

		while (true) {

			if (s2.isEmpty()) {
				break;
			}

			int top2 = s2.peek();

			if (top2 + sumTillNow <= x) {

				s2.pop();

				sumTillNow = sumTillNow + top2;

				moves++;

			} else {

				while (!s1.isEmpty() && sumTillNow > x) {

					sumTillNow = sumTillNow - s1.pop();
					moves--;
					
					if(sumTillNow+top2<x) {
						
					}

				} 

				if (sumTillNow > x) {

					break;

				}
			}

		}

		return moves;

	}

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

}
