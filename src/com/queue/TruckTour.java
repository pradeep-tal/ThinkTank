package com.queue;

import java.util.LinkedList;
import java.util.Queue;

public class TruckTour {

	static class Pair {

		int index;

		int distanceCanTravel;

		int nextPetrolPump;

		boolean isVisited;

		public Pair(int i, int j, int k) {

			this.index = i;
			this.distanceCanTravel = j;
			this.nextPetrolPump = k;
		}

	}

	public static void main(String[] args) {

		int[][] petrolPumps = { { 1, 5 }, { 10, 3 }, { 3, 4 } ,{1,9} };

		Queue<Pair> queue = new LinkedList<Pair>();

		int size = petrolPumps.length;

		for (int i = 0; i < size; i++) {

			Pair pair = new Pair(i, petrolPumps[i][0], petrolPumps[i][1]);
			queue.add(pair);
		}

		int visitedCount = 0;

		int currentPP = -1;

		while (currentPP == -1 && visitedCount <= size + 1) {

			Pair pp = queue.poll();

			visitedCount++;

			if (!pp.isVisited && pp.distanceCanTravel >= pp.nextPetrolPump) {

				currentPP = pp.index;

				int distanceCanTravel = pp.distanceCanTravel - pp.nextPetrolPump;
				
				int tsize=queue.size();

				while (tsize >0) {

					Pair ppp = queue.poll();

					distanceCanTravel = distanceCanTravel + ppp.distanceCanTravel - ppp.nextPetrolPump;

					tsize--;
				
					queue.add(ppp);
				
				}
				
				if(distanceCanTravel <0)
				{
					break;
				}
				
				
			} else {
				queue.add(pp);
			}

			pp.isVisited = true;

		}

		System.out.println(currentPP);

	}

}
