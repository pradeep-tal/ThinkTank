package com.test;

public class PascalTriangle {
	
	public static void main(String args[]) {
	
		int n=8;
		int[][] arr=new int[n][n];
		
		for(int i=0;i<n;i++) {
			
			for(int j=0;j<=i;j++) {
				
				if(j==0 || i==j) {
					arr[i][j]=1;
				}
				else {
					arr[i][j]=arr[i-1][j]+arr[i-1][j-1];
				}
				
				System.out.print(arr[i][j]+" ");
				
			}
			
			System.out.println();
			
		}
		
		
	
	}

}
