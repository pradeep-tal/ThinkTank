package hackerrank.dp;


public class SherlockAndCost {

	public static void main(String[] args) {

		int[] arr1 = { 43,36,62,20,71,56,27,48,66,94,14,39,4,47,19,20,14,94,95,42,84,3,49,33,51,41,1,60,80,33,47,96,39,32,4,96,17,72 };
		
		int[] arr= {40,68,48,18,93,57,48,97,81,56,86,47,53,26};
		
		int N=arr.length;

		int[] A = new int[arr.length];

		for (int i = 1; i <= arr.length; i++) {

			if (i % 2 != 0) {

				A[i - 1] = Math.min(arr[i - 1],1);

			}else
			{
				A[i - 1] = Math.max(arr[i - 1],1);
			}

		}
		
		int sum=0;
	
		for(int i=2;i<=N;i++) {
			
			sum=sum+Math.abs(A[i-1]-A[i-2]);
			
		}
		
		System.out.println(sum);
		

	}

}
