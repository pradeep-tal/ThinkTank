package hackerrank.strings.geeks;

import java.util.Arrays;
import java.util.HashSet;

public class CountOfStringsWithConstraints {

	static int count = 0;
	
	static HashSet<String> s=new HashSet<>();

	static int countOfB = 0;

	static int countOfC = 0;

	public static void main(String[] args) {

		char[] chars = { 'a', 'b', 'c' };

		recKLengthStrings(new char[3], chars, 0, 3, 0, 0);

		System.out.println("count " + count);
		
		System.out.println(s.size());

	}

	private static void recKLengthStrings(char[] data, char[] chars, int i, int len, int cCount, int bCount) {

		boolean isValid = false;

		for (int k = 0; k < chars.length; k++) {

			if (bCount < 1 && chars[k] == 'b') {

				data[i] = chars[k];

				bCount = bCount + 1;

				isValid = true;
			}

			else if (cCount < 2 && chars[k] == 'c') {

				data[i] = chars[k];

				cCount = cCount + 1;
				isValid = true;
			} else if (chars[k] == 'a') {
				data[i] = chars[k];
				isValid = true;
			}

			if (isValid) {

				if (i + 1 == len) {
					System.out.println(Arrays.toString(data));
					count = count + 1;
					s.add(Arrays.toString(data));
				} else {

					recKLengthStrings(data, chars, i + 1, len, bCount, cCount);
				}
			}
		}
	}

}
