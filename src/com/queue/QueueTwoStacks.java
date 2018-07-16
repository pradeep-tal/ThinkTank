package com.queue;

import java.util.Scanner;
import java.util.Stack;

public class QueueTwoStacks {

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String args[]) {

		Stack<Integer> s1 = new Stack<Integer>();

		Stack<Integer> s2 = new Stack<Integer>();

		int cases = Integer.parseInt(scanner.nextLine());

		for (int i = 1; i <= cases; i++) {

			String[] nd = scanner.nextLine().split(" ");

			int op = Integer.parseInt(nd[0]);

			if (op == 1) {

				int val = Integer.parseInt(nd[1]);

				enqueue(val, s1);

			} else if (op == 2) {
				deQueue(s1, s2, true);
			} else if(op==3){
				System.out.println(deQueue(s1, s2, false));
			}

		}

		scanner.close();

	}

	private static void enqueue(int i, Stack<Integer> s1) {

		s1.push(i);

	}

	private static int deQueue(Stack<Integer> s1, Stack<Integer> s2, boolean isDelete) {

		if (s1.isEmpty() && s2.isEmpty()) {
			return -1;

		}

		if (s2.isEmpty()) {

			while (!s1.isEmpty()) {
				int x = s1.pop();

				s2.push(x);
			}
		}

		return isDelete ? s2.pop() : s2.peek();

	}

}
