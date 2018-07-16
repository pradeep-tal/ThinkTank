package com.heap;

import java.util.Comparator;

import com.heap.AvgWaitingTime.Pair;

public class CustWaitComparator implements Comparator<Pair> {

	@Override
	public int compare(Pair o1, Pair o2) {
		return o1.waitTime != o2.waitTime ? (o1.waitTime < o2.waitTime ? -1 : 1) : 0;
	}

}
