package hackerrank.dp;

import java.util.Arrays;

public class CoinChangeProblem {

	public static void main(String args[]) {

		int[] coins = { 1, 2, 3 };

		int n = 4;

		System.out.println(countWays(coins,coins.length,n));

	}

	static Long getWays(long n, long[] coins) {

		long[] r = new long[10];

		r[0] = 0;

		for (int i = 1; i <= n; i++) {

			for (int j = 0; j < coins.length; j++) {

				if (coins[j] < i) {

					long sub_res = r[(int) (i - coins[j])];
					

					if (sub_res > 0) {
						r[i] = r[i] + 1;
					}

				} else if (coins[j] == i) {
					r[i] = r[i] + 1;
				}

			}

		}

		return r[(int)n];

	}
	
	static long countWays(int S[], int m, int n) {
		
        long[] table = new long[n+1];
 
        Arrays.fill(table, 0);   //O(n)
 
        table[0] = 1;
 
        for (int i=0; i<m; i++)
            for (int j=S[i]; j<=n; j++)
                table[j] += table[j-S[i]];
 
        return table[n];
	}

}
