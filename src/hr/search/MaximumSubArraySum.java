package hr.search;

public class MaximumSubArraySum {

	public static void main(String[] args) {

		long[] arr = { 3,3,9,9,5};
		int m = 7;

		System.out.println(subArraySum(arr, m));

	}

	private static long subArraySum(long[] arr, int m) {

		int n = arr.length;

		long sum = 0;

		long max = -1;

		for (int i = 0; i < n; i++) {

			sum = 0;

			for (int j = i; j < n; j++) {
				long tsum = (arr[j] % m);
				if (i == 0) {

					if (tsum >= max) {
						max = tsum;
					}
				}

				sum = sum + tsum;
				

				sum = sum % m;
				
				if (sum >= max) {
					max = sum;
				}
			}
			

		}
		return max;
		

	}

}
