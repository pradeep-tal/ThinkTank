package hackerrank.dp;

public class LongestCommonSubSequence {

	public static void main(String[] args) {

		String s1 = "geeksforgeeks";
		String s2 = "pea";

		int count=lcs(s1, s2, s1.length(), s2.length());
		
		System.out.println(count);

	}

	private static int lcs(String s1, String s2, int m, int n) {

		int[][] lcs = new int[m + 1][n + 1];

		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {

				if (i == 0 || j == 0) {
					lcs[i][j] = 0;
				} else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
					lcs[i][j] = lcs[i - 1][j - 1] + 1;
				} else {
					lcs[i][j] = Math.max(lcs[i][j - 1], lcs[i - 1][j]);
				}
			}
		}

		return lcs[m][n];
		
	}

}
