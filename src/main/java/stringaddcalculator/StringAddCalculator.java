package stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String DEFAULT_DELIMITER_REGEX = "[,:]";

	private StringAddCalculator() {
	}

	public static int splitAndSum(String input) {
		if (isBlank(input)) {
			return 0;
		}
		String[] strings = split(input);
		return sum(strings);
	}

	private static int sum(String[] strings) {
		return Arrays.stream(strings)
			.map(v -> {
				int number;
				try {
					number = Integer.parseInt(v);
				} catch (NumberFormatException e) {
					throw new RuntimeException();
				}
				if (number < 0) {
					throw new RuntimeException();
				}
				return number;
			}).mapToInt(Integer::intValue).sum();
	}

	private static String[] split(String input) {
		Matcher matcher = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			return matcher.group(2).split(customDelimiter);
		}
		return input.split(DEFAULT_DELIMITER_REGEX);
	}

	private static boolean isBlank(String input) {
		return input == null || input.isEmpty();
	}
}
