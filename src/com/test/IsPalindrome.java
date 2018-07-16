package com.test;

public class IsPalindrome {

	public static void main(String[] args) {
		
		int a=121;
		
		String s="";
		
		while(a!=0) {
			
			int num=a%10;
			
			s=s+num;
			
			a=a/10;
			
		}
		
		
		System.out.println(s);

		System.out.print(Integer.valueOf(s)==a);
		
		
	}

}
