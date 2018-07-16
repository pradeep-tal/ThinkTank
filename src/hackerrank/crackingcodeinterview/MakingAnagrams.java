package hackerrank.crackingcodeinterview;

public class MakingAnagrams {

	public static void main(String[] args) {

		String first = "a";
		String second = "b";

		int[] counts = new int[26];
		int[] counts2 = new int[26];

		for (int i = 0; i < first.length(); i++) {

			int c = (int) first.charAt(i);

			int pos = c - 97;

			counts[pos] = counts[pos] + 1;

		}

		for (int i = 0; i < second.length(); i++) {

			int c = (int) second.charAt(i);

			int pos = c - 97;

			counts2[pos] = counts2[pos] + 1;

		}
		
		int tot=0;
		
		for(int i=0;i<counts.length;i++) {
			
			tot=tot+Math.abs(counts[i]-counts2[i]);
			
		}
		

	}

}
