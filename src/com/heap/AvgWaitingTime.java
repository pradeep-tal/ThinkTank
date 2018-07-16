package com.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class AvgWaitingTime {

	static class Pair {

		public int arrivalTime;

		public int makingTime;

		public long waitTime;

		public Pair(int arrivalTime, int makingTime) {

			this.arrivalTime = arrivalTime;

			this.makingTime = makingTime;
		}
	}

	static int minimumAverage(int[][] customers) {

		PriorityQueue<Pair> priorityQueue = new PriorityQueue<Pair>(new CustComparator());

		PriorityQueue<Pair> waitTimeQueue = new PriorityQueue<Pair>(new CustWaitComparator());

		long timeTaken = 0;

		long waitTime = 0;

		for (int i = 0; i < customers.length; i++) {

			Pair p = new Pair(customers[i][0], customers[i][1]);

			priorityQueue.add(p);

		}

		int startTime = 0;

		if (priorityQueue.size() > 0) {

			Pair p = priorityQueue.poll();

			startTime = p.arrivalTime;

			timeTaken = startTime + p.makingTime;

			waitTime = p.makingTime;

			System.out.println("wait 1 " + waitTime);
		}

		int size = priorityQueue.size();

		while (size > 0) {

			Pair pp = priorityQueue.poll();

			long currentWaitTime = Math.max(timeTaken - pp.arrivalTime, 0);

			pp.waitTime = currentWaitTime + pp.makingTime;

			waitTimeQueue.add(pp);

			size--;

		}

		while (!waitTimeQueue.isEmpty()) {

			Pair start = waitTimeQueue.poll();

			timeTaken = timeTaken + start.makingTime;

			waitTime = waitTime + start.waitTime;

			System.out.println("wait " + start.waitTime + " " + start.arrivalTime);

			int s = waitTimeQueue.size();

			while (s > 0) {

				Pair next = waitTimeQueue.poll();

				next.waitTime = timeTaken + next.makingTime - next.arrivalTime;

				if (next.waitTime < 0) {
					next.waitTime = next.makingTime;
				}

				waitTimeQueue.add(next);

				s--;
			}
		}

		System.out.println(timeTaken);

		return (int) (waitTime / customers.length);

	}

	static class CustComparator implements Comparator<Pair> {

		@Override
		public int compare(Pair o1, Pair o2) {

			if (o1.arrivalTime != o2.arrivalTime) {
				return o1.arrivalTime < o2.arrivalTime ? -1 : 1;
			} else {

				return o1.makingTime == o2.makingTime ? 0 : (o1.makingTime < o2.makingTime ? -1 : 1);
			}
		}

	}

	static class CustWaitComparator implements Comparator<Pair> {

		@Override
		public int compare(Pair o1, Pair o2) {

			long absWaitTime1 = Math.abs(o1.waitTime - o1.arrivalTime);

			System.out.println(absWaitTime1);
			
			long absWaitTime2 = Math.abs(o2.waitTime - o2.arrivalTime);

			System.out.println(absWaitTime2);

			return absWaitTime1 != absWaitTime2 ? (absWaitTime1 < absWaitTime2 ? -1 : 1) : 0;
		}

	}

	public static void main(String[] args) {

		// op 1418670047
		/*
		 * int[][] customers1 = { { 961148050, 385599125 }, { 951133776, 376367013 }, {
		 * 283280121, 782916802 }, { 317664929, 898415172 }, { 980913391, 847912645 } };
		 */

		int[][] customers = { { 961148050, 385599125 }, { 951133776, 376367013 }, { 283280121, 782916802 }, { 317664929, 898415172 }, { 980913391, 847912645 }};

		// int[][] customers = { { 0, 9 }, { 10, 4 } };

		PriorityQueue<Pair> q = new PriorityQueue<Pair>(new CustComparator());

		for (int i = 0; i < customers.length; i++) {

			q.add(new Pair(customers[i][0], customers[i][1]));
		}

		while (!q.isEmpty()) {

			Pair p = q.poll();

			System.out.println(p.arrivalTime + " " + p.makingTime);
		}

		System.out.println(minimumAverage(customers));

	}

}
