package util;

public class Utils {
	
	public static void printArray(int[] arr,int n) {
		
		for(int i=0;i<n;i++) {
			System.out.print(arr[i]+" ");
		}
		
		System.out.println();
		
	}

	public static void print2DArray(int[][] darr) {

		for(int i=0;i<darr.length;i++) {
			for(int j=0;j<darr[i].length;j++) {
				System.out.print(darr[i][j] +" ");
			}
			System.out.println();
		}
		
	}

}
