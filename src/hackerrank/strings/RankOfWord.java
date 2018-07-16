package hackerrank.strings;

import java.util.Scanner;

public class RankOfWord {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		int a;
		a = in.nextInt();

		for (int i = 0; i < a; i++) {
			String b = in.next();
			int rank = findRank(b);
			System.out.println(rank);
		}
		
		in.close();
		
	

	}

	static int fact(int n) {
		return (n <= 1) ? 1 : n * fact(n - 1);
	}

	static int findSmallerInRight(String str, int low, int high) {
		int countRight = 0, i;

		for (i = low + 1; i <= high; ++i)
			if (str.charAt(i) < str.charAt(low))
				++countRight;

		return countRight;
	}

	static int findRank(String str) {
		int len = str.length();
		int mul = fact(len);
		int rank = 1;
		int countRight;

		for (int i = 0; i < len; ++i) {
			mul /= len - i;

			countRight = findSmallerInRight(str, i, len - 1);

			rank += countRight * mul;
		}

		return rank;
	}

}
