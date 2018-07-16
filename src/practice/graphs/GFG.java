package practice.graphs;

public class GFG {

	public static void main(String[] args) {
		Graph graph = new Graph(5);

		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);

		//graph.printEdges();

		//graph.BFS(0);
		System.out.println("-----------------");

		Graph g = new Graph(4);

		g.addEdge(0, 1);
		g.addEdge(0, 2);
		g.addEdge(1, 2);
		g.addEdge(2, 0);
		g.addEdge(2, 3);
		g.addEdge(3, 3);

		//g.DFS(2);

		System.out.println("-----------------");

		Graph g1 = new Graph(5);

		g1.addEdge(1, 0);
		g1.addEdge(0, 2);
		g1.addEdge(2, 1);
		g1.addEdge(0, 3);
		g1.addEdge(1, 4);

		//g1.DFS(0);

		Graph sp = new Graph(8);

		sp.addEdge(0, 1);
		sp.addEdge(0, 3);
		sp.addEdge(1, 2);
		sp.addEdge(3, 4);
		sp.addEdge(3, 7);
		sp.addEdge(4, 5);
		sp.addEdge(4, 6);
		sp.addEdge(4, 7);
		sp.addEdge(5, 6);
		sp.addEdge(6, 7);
		
		sp.shortestPath(2, 6);
		
		System.out.println(sp.dist[6]);
		
		int[] preds=sp.pred;
		
		int i=6;
		
		while(preds[i]!=-1) {
			
			System.out.print(preds[i]+"-> ");
			
			i=preds[i];
		}
		
		

	}

}
