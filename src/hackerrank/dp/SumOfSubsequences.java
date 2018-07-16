package hackerrank.dp;

import java.math.BigInteger;
import java.util.HashSet;

public class SumOfSubsequences {

	static HashSet<String> set = new HashSet<>();

	// op 186472174

	public static void main(String[] args) {

		String s = "123";

		System.out.println(substrings(s));

	}

	static int substrings(String s) {

		BigInteger op = recSubfunc(s, 0, s.length(),new BigInteger(s));

		return op.intValue();

	}

	private static BigInteger recSubfunc(String s, int i, int n,BigInteger next) {

		if (i < n) {

			BigInteger mod = next.mod(new BigInteger("1000000007"));
			
			BigInteger left=recSubfunc(s, i, n - 1,next.divide(new BigInteger("10")));
			
			BigInteger right=recSubfunc(s, i + 1, n,next.divide(new BigInteger("100")));

			return mod.add(left).add(right);

		}

		return new BigInteger("0");

	}

}
