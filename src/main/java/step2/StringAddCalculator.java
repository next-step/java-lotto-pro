package step2;

import java.util.Arrays;

public class StringAddCalculator {
	private static final String NUMBER_REGEX = "^[0-9]+$";

	public static int splitAndSum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		if (input.matches(NUMBER_REGEX)) {
			return Integer.parseInt(input);
		}

		String[] numbers = input.split(",");

		return Arrays.stream(numbers)
			.mapToInt(Integer::parseInt)
			.sum();
	}
}
