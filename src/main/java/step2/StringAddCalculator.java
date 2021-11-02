package step2;

import java.util.Arrays;

public class StringAddCalculator {
	private static final String NUMBER_REGEX = "^[0-9]+$";

	public static int splitAndSum(String input) {
		String[] numbers = Splitter.split(input);
		validateNumbers(numbers);
		return sum(numbers);
	}

	private static int sum(String[] numbers) {
		return Arrays.stream(numbers)
			.mapToInt(Integer::parseInt)
			.sum();
	}

	private static void validateNumbers(String[] numbers) {
		if (isNegativeNumberOrNotNumber(numbers)) {
			throw new RuntimeException();
		}
	}

	private static boolean isNegativeNumberOrNotNumber(String[] numbers) {
		return Arrays.stream(numbers)
			.anyMatch(number -> !number.matches(NUMBER_REGEX));
	}
}
