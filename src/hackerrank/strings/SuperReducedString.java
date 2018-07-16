package hackerrank.strings;

public class SuperReducedString {

	public static void main(String args[]) {

		String s = "baa";

		s = super_reduced_string(s);

		System.out.println(s);

	}

	private static String super_reduced_string(String s) {

		int n = s.length();

		int i = 0;

		while (i < n) {

			String s1 = s.substring(i, i + 1);

			String replaced = s.replace(s1 + s1, "");

			if (replaced.equals(s)) {
				i++;
			} else {
				s = replaced;

				n = replaced.length();
			}

		}

		if (s.isEmpty())
			return "Empty String";
		else
			return s;
	}

}
