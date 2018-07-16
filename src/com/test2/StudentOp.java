package com.test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentOp {

	public static void main(String[] args) {

		List<Student> stList = new ArrayList<>();

		Map<String, String> m = new HashMap<>();

		stList.add(new Student("Pradeep", "dyapa"));

		for (Student s : stList) {

			m.put(s.getFirstName(), s.getLastName());

		}
		

	}
	

}
