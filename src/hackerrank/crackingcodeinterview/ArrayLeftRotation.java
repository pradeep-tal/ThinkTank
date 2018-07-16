package hackerrank.crackingcodeinterview;

public class ArrayLeftRotation {

	public static void main(String args[]) {

		int[] arr = { 1, 2, 3, 4, 5 };

		int d = 1;

		rotateArray(arr, d);

	}

	private static void rotateArray(int[] a, int k) {

		int n = a.length;

		int[] op = new int[n];

		int pos = 0;

		int r = n - k;

		for (int i = 0; i < n; i++) {

			if ((i + r) >= n) {
				pos = (i + r) - n;
			} else {
				pos = i + r;
			}

			op[pos] = a[i];

		}
		
		System.out.println(op);

	}
	
	
	

}
