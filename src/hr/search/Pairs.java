package hr.search;

import java.util.HashMap;
import java.util.Map;

public class Pairs {

	public static void main(String[] args) {
		
		int[] arr= {1,5,3,4,2 };
		
		int k=2;
		
		System.out.println(pairs(k, arr));
		
	}
	
	 static int pairs(int k, int[] arr) {
		 
		 Map<Integer, Integer> m=new HashMap<>();
		 
		 int cnt=0;
		 
		 for(int i=0;i<arr.length;i++) {
			 m.put(arr[i], arr[i]);
		 }
		 
		 for(int i=0;i<arr.length;i++) {
			 
			if(m.containsKey(arr[i]-k)) {
				cnt++;
			}
			 
		 }


		 return cnt;
	 }
}
