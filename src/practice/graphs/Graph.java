package practice.graphs;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

import hackerrank.crackingcodeinterview.IsBinarySearchTree;

public class Graph {

	int size;

	LinkedList<Integer>[] nodes;
	int[] dist;

	int[] pred;

	public Graph(int v) {
		this.size = v;

		nodes = new LinkedList[v];

		dist = new int[v];

		pred = new int[v];

		for (int i = 0; i < v; i++) {
			nodes[i] = new LinkedList<>();
			dist[i] = -1;
			pred[i] = -1;
		}

	}

	public void addEdge(int src, int dest) {

		nodes[src].add(dest);

		nodes[dest].add(src);

	}
	
	public void addEdgeDirected(int src, int dest) {

		nodes[src].add(dest);

	}

	public void printEdges() {

		if (nodes != null) {

			for (int i = 0; i < nodes.length; i++) {

				System.out.println("Adjacency list of vertex " + i);
				System.out.print("head");

				for (Integer e : nodes[i]) {

					System.out.print(" -> " + e);

				}
				System.out.println("\n");

			}

		}

	}

	public boolean shortestPath(int s, int dest) {

		boolean[] visited = new boolean[size];

		LinkedList<Integer> queue = new LinkedList<Integer>();

		visited[s] = true;

		queue.add(s);

		dist[s] = 0;

		while (queue.size() != 0) {

			s = queue.poll();

			System.out.print(s + " ");

			Iterator<Integer> it = nodes[s].listIterator();

			while (it.hasNext()) {

				int n = it.next();

				if (!visited[n]) {
					dist[n] = dist[s] + 1;

					pred[n] = s;

					queue.add(n);

					visited[n] = true;

					if (n == dest) {
						return true;
					}
				}

			}

		}
		return false;

	}

	public void BFS(int s) {

		boolean[] visited = new boolean[size];

		LinkedList<Integer> queue = new LinkedList<Integer>();

		visited[s] = true;

		queue.add(s);

		while (queue.size() != 0) {

			s = queue.poll();

			System.out.print(s + " ");

			Iterator<Integer> it = nodes[s].listIterator();

			while (it.hasNext()) {

				int n = it.next();

				if (!visited[n]) {

					queue.add(n);

					visited[n] = true;
				}

			}

		}

	}

	public void DFS(int s) {

		boolean[] visited = new boolean[size];

		Stack<Integer> stack = new Stack<>();

		stack.push(s);

		while (!stack.isEmpty()) {

			s = stack.pop();

			if (!visited[s]) {

				System.out.print(s + " ");
				visited[s] = true;
			}

			Iterator<Integer> it = nodes[s].listIterator();

			while (it.hasNext()) {

				int n = it.next();

				if (!visited[n]) {

					stack.push(n);
				}

			}

		}

	}

	public void DFSRec(int s) {

		boolean[] visited = new boolean[size];

		DFSUtil(s, visited);
	}

	private void DFSUtil(int s, boolean[] visited) {

		System.out.print(s + " ");

		visited[s] = true;

		Iterator<Integer> it = nodes[s].listIterator();

		while (it.hasNext()) {

			int n = it.next();

			if (!visited[n]) {

				DFSUtil(n, visited);

			}

		}

	}

}
