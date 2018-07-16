package hackerrank.strings;

public class CamelCase {

	public static void main(String[] args) {

		String s = "";
		
		int count = 0;

		if (!s.isEmpty())
			count = 1;

		for (int i = 0; i < s.length(); i++) {

			String c = s.substring(i, i + 1);

			if (c.equals(c.toUpperCase())) {

				count++;
			}
		}
		
		System.out.println(count);
	}

}
