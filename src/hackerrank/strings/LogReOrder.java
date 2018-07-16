package hackerrank.strings;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class LogReOrder {

	public static void main(String args[]) {

		List<String> l = new ArrayList<>();

		l.add("a1 abc drf ");

		l.add("a1 nks jlk ");

		List<String> op = new ArrayList<>();

		HashSet<String> s = new HashSet<>();

		for (String a1 : l) {

			int pos = a1.indexOf("\\s");

			String a2 = a1.substring(pos + 1);

			if (!a2.matches("[a-zA-Z]+")) {
				s.add(a1);
			} else {
				op.add(a1);
			}

		}

		Collections.sort(op, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {

				if (o1.length() != o2.length()) {
					return o1.length() - o2.length();
				} else {

					String[] arr1 = o1.split("\\s");

					String[] arr2 = o2.split("\\s");

					String s1 = new String();

					String s2 = new String();

					String k1 = arr1[0];

					String k2 = arr2[0];

					for (int i = 1; i < arr1.length; i++) {

						s1 = s1 + arr1[i];

					}

					for (int i = 1; i < arr2.length; i++) {

						s2 = s2 + arr2[i];

					}

					if (s1.compareTo(s2) == 0) {
						return k1.compareTo(k2);
					} else {
						return s1.compareTo(s2);
					}

				}

			}

		});

		int count = 0;

		for (String i1 : s) {
			op.add(i1);
		}

		for (String s22 : op) {
			System.out.println(s22);
		}

	}

}
