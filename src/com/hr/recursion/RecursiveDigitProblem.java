package com.hr.recursion;

import java.math.BigInteger;

public class RecursiveDigitProblem {

	public static void main(String[] args) {

		int digit = 148;

		int k = 1;
		
		String input="81";

		int sum = superdigit2(input,k);
		
		System.out.println(sum);

	}

	private static int superdigit2(String input, int k) {
		
		
		BigInteger in=new BigInteger(input).multiply(new BigInteger(String.valueOf(k)));
		
		BigInteger mod=in.remainder(new BigInteger(("9")));
		
		return mod.intValue()==0 ? 9 :mod.intValue();
	}

	private static int superdigit(int digit) {

		if (digit > 9) {

			int last = digit % 10;

			int remain = digit / 10;

			return last + superdigit(remain);

		}

		return digit;

	}

}
