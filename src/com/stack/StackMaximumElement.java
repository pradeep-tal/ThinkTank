package com.stack;

import java.util.Scanner;
import java.util.Stack;

public class StackMaximumElement {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {

		int t = Integer.valueOf(scanner.nextLine());

		Stack<stackNode> stack = new Stack<>();

		int max = Integer.MIN_VALUE;

		for (int i = 0; i < t; i++) {

			String[] n1N2N3 = scanner.nextLine().split(" ");

			int n1 = Integer.parseInt(n1N2N3[0].trim());

			if (n1 == 1) {

				int n2 = Integer.parseInt(n1N2N3[1].trim());

				max = Math.max(max, n2);

				stack.push(new stackNode(n2, max));
			} else if (n1 == 2) {

				stack.pop();

				if (stack.isEmpty()) {
					max = Integer.MIN_VALUE;
				} else {
					max = stack.peek().currMax;
				}

			} else {
				if (!stack.isEmpty())
					System.out.println(max);
				else
					System.out.println(0);
			}

		}

		scanner.close();

	}

	static class stackNode {

		public int val;

		public int currMax;

		public stackNode(int val, int currMax) {

			this.val = val;
			this.currMax = currMax;

		}

	}

}
