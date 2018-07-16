package hackerrank.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class FrequentlyUsedWords {

	public static void main(String[] args) {

		String s = "a's";

		List<String> wordsToexecute = new ArrayList<>();

		wordsToexecute.add("is");
		wordsToexecute.add("are");

		List<String> op1 = mostFreqWords(s, wordsToexecute);

		for (String s1 : op1) {
			System.out.println(s1);
		}

	}

	private static List<String> mostFreqWords(String literatureText, List<String> wordsToExclude) {
		
		String lt2=literatureText.replaceAll("[^a-zA-Z]", "909");
		
		System.out.println(lt2);
		
		String[] arr = lt2.split("909");

		List<String> op = new ArrayList<>();

		HashMap<String, Integer> map = new HashMap<>();

		int maxCount = 0;

		for (String a : arr) {

			String alowr = a.toLowerCase();

			if (!wordsToExclude.contains(alowr)) {

				if (map.containsKey(alowr)) {

					int eCount = map.get(alowr);

					if (eCount + 1 > maxCount) {
						maxCount = eCount + 1;
					}

					map.put(alowr, eCount + 1);

				} else {
					map.put(alowr, 1);

					if (1 > maxCount) {
						maxCount = 1;
					}
				}

			}

		}



		Set<String> keys = map.keySet();

		for (String key : keys) {
			Integer val = map.get(key);

			if (val == maxCount) {
				op.add(key);

			}
		}

		return op;

	}

}
