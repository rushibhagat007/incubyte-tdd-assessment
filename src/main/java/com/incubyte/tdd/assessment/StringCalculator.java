package com.incubyte.tdd.assessment;

public class StringCalculator {

	public int add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}

		String delimiter = ",";
	    String input = numbers;

	    if (numbers.startsWith("//")) {
	        int index = numbers.indexOf("\n");
	        delimiter = numbers.substring(2, index);
	        input = numbers.substring(index + 1);
	    }

	    String[] nums = input.split("[,\n" + delimiter + "]");
	    int sum = 0;
	    for (String num : nums) {
	        sum += Integer.parseInt(num);
	    }
	    return sum;
	}
}