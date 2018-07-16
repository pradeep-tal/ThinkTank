package practice.graphs;

import java.util.Iterator;
import java.util.Stack;

public class StronglyConnectedGraph {

	public static void main(String[] args) {

		Graph g = new Graph(5);
		g.addEdgeDirected(1, 0);
		g.addEdgeDirected(0, 2);
		g.addEdgeDirected(2, 1);
		g.addEdgeDirected(0, 3);
		g.addEdgeDirected(3, 4);
		
		g.printEdges();

		System.out.println("Following are strongly connected components " + "in given graph ");
		printSCCs(g, 5);

	}

	private static void printSCCs(Graph g, int V) {

		boolean[] visited = new boolean[V];

		Stack<Integer> stack = new Stack<Integer>();

		for (int i = 0; i < V; i++) {

			if (!visited[i]) {
				fillOrder(g, i, stack, visited);
			}
		}


		Graph gt = transPose(g, V);

		visited = new boolean[V];


		while (!stack.isEmpty()) {

			int v = stack.pop();

			if (!visited[v]) {

				DFSUtil(v, visited, gt);
				
				System.out.println("--");
			}

		}

	}

	private static void DFSUtil(int v, boolean[] visited, Graph gt) {

		

		Stack<Integer> stack = new Stack<>();

		stack.push(v);

		while(!stack.isEmpty()) {

			int s = stack.pop();
			
			visited[s] = true;
			
			System.out.print(s);

			Iterator<Integer> it = gt.nodes[s].listIterator();

			while (it.hasNext()) {
				Integer e = it.next();

				if (!visited[e]) {
					stack.push(e);
				}

			}

		}

	}

	private static Graph transPose(Graph g, int v) {

		Graph op = new Graph(v);

		for (int i = 0; i < v; i++) {

			Iterator<Integer> it = g.nodes[i].listIterator();

			while (it.hasNext()) {
				
				int head=it.next();
				System.out.println("head-> "+head +" i->"+i);
				op.nodes[head].add(i);
			}

		}

		return op;
	}

	private static void fillOrder(Graph g, int i, Stack<Integer> stack, boolean[] visited) {

		visited[i] = true;

		Iterator<Integer> it = g.nodes[i].iterator();

		while (it.hasNext()) {
			Integer v = it.next();
			if (!visited[v]) {

				fillOrder(g, v, stack, visited);
			}

		}

		stack.push(i);

	}

}
