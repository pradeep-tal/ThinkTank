package hackerrank.crackingcodeinterview;

public class MergeSort {

	public static void main(String[] args) {

		int[] arr = { 12, 11, 13, 5, 6, 7 };

		sort(arr, 0, arr.length - 1);

	}

	private static void sort(int[] arr, int l, int r) {

		if (l < r) {
			int m = (l + r) / 2;
			
			sort(arr,l,m);
			sort(arr,m+1,r);
			
			merge(arr,l,m,r);

		}

	}

	private static void merge(int[] arr, int l, int m, int r) {
		
	}

}
