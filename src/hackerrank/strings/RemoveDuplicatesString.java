package hackerrank.strings;

public class RemoveDuplicatesString {

	public static void main(String[] args) {

		String s = "pradeep";

		System.out.println(removeDups(s));

	}

	private static String removeDups(String s) {

		String str = new String();

		int ln = s.length();

		for (int i = 0; i < ln; i++) {
			char c = s.charAt(i);

			if (str.indexOf(c) < 0) {

				str += c;

			}
		}

		return str;

	}

}
