package com.hr.recursion;

public class ReverseStrRecursion {

	public static void main(String args[]) {

		String s = "ABCD";
		

		System.out.println(reverse(s));

	}

	private static String reverse(String s) {

		return reverseRec(s, 0, s.length() - 1);

	}

	private static String reverseRec(String s, int i, int j) {

		if (i <= j) {

			String ns=s.substring(0,i)+s.substring(j,j+1)+s.substring(i+1, j)+s.substring(i,i+1)+s.substring(j+1);
			
			 return reverseRec(ns,i+1,j-1);
			
		}
		
		return s;
		

		
		
	}

}
