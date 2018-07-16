package practice.graphs;

public class DijkstraShortestPath {

	public static void main(String[] args) {

		int graph[][] = new int[][] { { 0, 4, 0, 0, 0, 0, 0, 8, 0 }, { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
				{ 0, 8, 0, 7, 0, 4, 0, 0, 2 }, { 0, 0, 7, 0, 9, 14, 0, 0, 0 }, { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
				{ 0, 0, 4, 14, 10, 0, 2, 0, 0 }, { 0, 0, 0, 0, 0, 2, 0, 1, 6 }, { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
				{ 0, 0, 2, 0, 0, 0, 6, 7, 0 } };

		dijkStra(graph, 0, 9);

	}

	private static void dijkStra(int[][] graph, int src, int V) {

		int[] dist = new int[V];

		int[] pred = new int[V];

		Boolean[] sptSet = new Boolean[V];

		for (int i = 0; i < V; i++) {

			dist[i] = Integer.MAX_VALUE;

			sptSet[i] = false;

			pred[i] = -1;

		}

		dist[src] = 0;

		for (int i = 0; i < V - 1; i++) {

			int u = minDistanceVertex(dist, sptSet);

			sptSet[u] = true;

			for (int j = 0; j < V; j++) {

				if (!sptSet[j] && graph[u][j] != 0 && dist[u] != Integer.MAX_VALUE
						&& (dist[u] + graph[u][j] < dist[j])) {

					dist[j] = dist[u] + graph[u][j];
					pred[j]=u;

				}

			}

		}

		printSolution(dist);
		
		printSolution(pred);

	}

	static void printSolution(int dist[]) {
		System.out.println("Vertex   Distance from Source");
		for (int i = 0; i < dist.length; i++)
			System.out.println(i + " tt " + dist[i]);
	}

	private static int minDistanceVertex(int[] dist, Boolean[] sptSet) {

		int min = Integer.MAX_VALUE, min_index = -1;

		for (int i = 0; i < dist.length; i++) {

			if (!sptSet[i] && dist[i] < min) {

				min = dist[i];

				min_index = i;
			}

		}
		return min_index;
	}

}
