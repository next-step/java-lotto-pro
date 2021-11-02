package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private static final String NUMBER_REGEX = "^[0-9]+$";

	public static int splitAndSum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		if (input.matches(NUMBER_REGEX)) {
			return Integer.parseInt(input);
		}

		String[] numbers = input.split(",|:");
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			numbers = m.group(2).split(customDelimiter);

			return Arrays.stream(numbers)
				.mapToInt(Integer::parseInt)
				.sum();
		}

		return Arrays.stream(numbers)
			.mapToInt(Integer::parseInt)
			.sum();
	}
}
