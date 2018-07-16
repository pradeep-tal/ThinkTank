package hackerrank.crackingcodeinterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class FrequencyMap {

	public static void main(String args[]) {
		Map<Integer, Integer> m = new LinkedHashMap<>();

		m.put(5, 2);
		m.put(2, 2);

		Comparator<Map.Entry<Integer, Integer>> comp = new Comparator<Map.Entry<Integer, Integer>>() {

			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o1.getValue().compareTo(o2.getValue());
			}

		};

		List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(m.entrySet());

		Collections.sort(entries, comp);
		m.clear();

		for (Map.Entry<Integer, Integer> e : entries) {
			System.out.println(e.getKey() + " " + e.getValue());
		}

	}

}
