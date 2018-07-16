package hackerrank.strings;

public class PanagramChecking {

	public static void main(String[] args) {

		String s = "The quick brown fox jumps over the  dog";

		boolean isPanagram = checkPanagram(s);
		
		System.out.println(isPanagram);

	}

	private static boolean checkPanagram(String s) {

		boolean[] mark = new boolean[26];

		int n = s.length();

		int index = 0;

		for (int i = 0; i < n; i++) {

			char c = s.charAt(i);

			if (c >= 'A' && c <= 'Z') {

				index = c - 'A';
			} else if (c >= 'a' && c <= 'z') {
				index = c - 'a';
			}
			mark[index]=true;

		}
		
		for(int i=0;i<26;i++) {
			if(!mark[i])
				return false;
		}

		return true;
	}

}
