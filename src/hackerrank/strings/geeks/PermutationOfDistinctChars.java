package hackerrank.strings.geeks;

public class PermutationOfDistinctChars {

	public static void main(String[] args) {

		int index = 0;

		char[] s = { 'A', 'B','A' };

		permute(s, index);

	}
	
	

	private static void permute(char[] s, int index) {

		if (index == s.length - 1) {

			System.out.println(s);

		}

		for (int i = index; i < s.length; i++) {
			
			boolean check = shouldSwap(s, index, i);

			if(check) {
				swap(i, index, s);

				permute(s, index + 1);
				
				swap(i, index, s);
			}

		}

	}

	private static boolean shouldSwap(char[] s, int index, int end) {
		
		 for (int i = index; i < end; i++) 
		        if (s[i] == s[end])
		            return false;
		    return true;

		
	}



	private static void swap(int i, int index, char[] s) {

		char temp = s[i];
		s[i] = s[index];
		s[index] = temp;

	}

}
