package com.test;

public class StringPalindrome {

	public static void main(String args[]) {
		
		String s="malayalam";
		
		int n=s.length();
		
		int j=0;
		
		boolean isPalindrome=true;
		
		for(int i=n-1;i>=0;i--) {
			
			System.out.print(s.charAt(i));
			
			if(s.charAt(i)!=s.charAt(j)) {
				isPalindrome=false;
				break;
			}
			j++;
		}
		
		
		System.out.println(isPalindrome);
		
	}
	
}
