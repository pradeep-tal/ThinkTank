package hr.search;

public class MaxSubArraySumRec {

	static long max = -1;

	public static void main(String[] args) {

		long[] arr = { 3, 3, 9, 9, 5 };
		int m = 7;

		System.out.println(subArraySum(arr, m));

	}

	private static long subArraySum(long[] arr, int m) {

		int i = 0;

		subArrSumRec(i, arr, m, arr.length);

		return max;
	}

	private static void subArrSumRec(int i, long[] arr, long m, int n) {

		if (i < n) {

			long e = arr[i];

			long mode = e % m;

			if (max < mode) {
				max = mode;
			}

			for (int k = i + 1; k < n; k++) {

				e = arr[k];

				mode = mode + e % m;
				
				mode=mode%m;

				if (max < mode) {
					max = mode;
				}

			}

			subArrSumRec(i + 1, arr, m, n);

		}

	}

}
