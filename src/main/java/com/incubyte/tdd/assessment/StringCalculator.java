package com.incubyte.tdd.assessment;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

	public int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}

		String delimiter = ",";
		String input = numbers;

		if (numbers.startsWith("//")) {
			int start = numbers.indexOf("[");
			int end = numbers.indexOf("]");
			if (start != -1 && end != -1) {
				delimiter = numbers.substring(start + 1, end);
			} else {
				delimiter = numbers.substring(2, 3);
			}
			input = numbers.substring(numbers.indexOf("\n") + 1);
		}

		String[] nums = input.split("[,\n" + delimiter + "]");
		int sum = 0;
		List<Integer> negativeNumbers = new ArrayList<>();

		for (String num : nums) {
			if (!num.isEmpty()) {
				int n = Integer.parseInt(num);
				if (n < 0) {
					negativeNumbers.add(n);
				} else if (n <= 1000) {
					sum += n;
				}
			}
		}

		if (!negativeNumbers.isEmpty()) {
			throw new IllegalArgumentException("Negative numbers not allowed: " + negativeNumbers);
		}
		return sum;
	}
}