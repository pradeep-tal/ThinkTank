package hackerrank.dp;

public class SubSequenceProduct {

	static int[][] darr;

	public static void main(String[] args) {

		int[] arr = { 0,0,0,602977064,0,75372133,0,678349197,0,0,678349197,376860665,0,678349197,0,376860665,0,0,0,0,602977064,0,0,0,0,150744266,0,0,678349197,150744266,75372133,0,150744266,0,0,0,0,0,0,0,376860665,527604931,0,0,301488532,0,602977064,0,150744266,0,452232798,452232798,602977064,0,0,0 };

		int m = 75372133;
		int k = 0;

		howManyGoodSubarrays(arr, m, k);

	}

	static long howManyGoodSubarrays(int[] A, int m, int k) {

		darr = new int[A.length][A.length];

		long prod = prod(A, 0, A.length);

		long tot = subRecFun(A, 0, A.length - 1, m, k, prod);

		System.out.println(tot);

		return tot;

	}

	private static long subRecFun(int[] arr, int i, int n, int m, int k, long prod) {

		if (i <= n) {

			System.out.println("{" + i + "," + n + "}");

			int val = darr[i][n];

			int c = 0;

			if (val != 1) {

				darr[i][n] = 1;

				if (prod % m == k) {
					c++;
				}

				return c + subRecFun(arr, i, n - 1, m, k, arr[n] != 0 ? (prod / arr[n]) : (i==n-1 ? arr[i] : prod))
						+ subRecFun(arr, i + 1, n, m, k, arr[i] != 0 ? (prod / arr[i]) : (i+1==n ? arr[n] : prod));

			}

		}
		return 0;
	}

	private static long prod(int[] arr, int i, int max) {

		long prod = 1;

		for (; i <= max; i++) {
			prod = prod * arr[i];

			if (prod == 0)
				return prod;
		}

		return prod;
	}

}
