package practice.graphs;

public class MaxBooleanRegion {

	static int row = 4, col = 5;

	static int rowNbr[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int colNbr[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

	static int max = -1;

	static int count = 0;

	public static void main(String args[]) {
		int[][] graph = { { 0, 0, 1, 1, 0 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 0, 0 }, { 0, 0, 0, 0, 1 } };
		;

		boolean[][] visited = new boolean[4][5];

		largestRegion(graph, visited);

		System.out.println(max);

	}

	private static void largestRegion(int[][] graph, boolean[][] visited) {

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < col; j++) {

				count = 0;

				if (graph[i][j] != 0 && !visited[i][j]) {

					count++;
					DFS(i, j, graph, visited);

					System.out.println(count);

					if (count > max) {
						max = count;
					}

				}
			}
		}

	}

	private static void DFS(int i, int j, int[][] graph, boolean[][] visited) {

		visited[i][j] = true;

		for (int k = 0; k < 8; k++) {

			if (isSafe(graph, i + rowNbr[k], j + colNbr[k], visited)) {

				System.out.println("i =" + i + " " + "j =" + j);

				count++;
				DFS(i + rowNbr[k], j + colNbr[k], graph, visited);

			}

		}

	}

	private static boolean isSafe(int[][] graph, int i, int j, boolean[][] visited) {
		return i >= 0 && j >= 0 && i < row && j < col && graph[i][j] != 0 && !visited[i][j];
	}

}
