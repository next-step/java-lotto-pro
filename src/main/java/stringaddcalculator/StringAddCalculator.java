package stringaddcalculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import stringaddcalculator.exception.NegativeNumberException;
import stringaddcalculator.exception.NotNumberException;

public class StringAddCalculator {
	private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
	private static final int ZERO_NUMBER = 0;
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
	private static final int DELIMITER_GROUP_NUMBER = 1;
	private static final int OPERAND_GROUP_NUMBER = 2;

	private StringAddCalculator() {
	}

	public static int splitAndSum(String input) {
		if (isBlank(input)) {
			return ZERO_NUMBER;
		}
		String[] strings = split(input);
		return sum(strings);
	}

	private static int sum(String[] strings) {
		return Arrays.stream(strings)
			.mapToInt(StringAddCalculator::getNumber)
			.sum();
	}

	private static int getNumber(String input) {
		return validatedNumber(input);
	}

	private static int validatedNumber(String v) {
		int number = parseInt(v);
		validateNegativeNumber(number);
		return number;
	}

	private static void validateNegativeNumber(int number) {
		if (number < ZERO_NUMBER) {
			throw new NegativeNumberException();
		}
	}

	private static int parseInt(String input) {
		int number;
		try {
			number = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new NotNumberException();
		}
		return number;
	}

	private static String[] split(String input) {
		Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
		if (matcher.find()) {
			return splitByCustomDelimiter(matcher);
		}
		return splitByDelimiter(input, DEFAULT_DELIMITER_REGEX);
	}

	private static String[] splitByDelimiter(String input, String defaultDelimiterRegex) {
		return input.split(defaultDelimiterRegex);
	}

	private static String[] splitByCustomDelimiter(Matcher matcher) {
		String customDelimiter = matcher.group(DELIMITER_GROUP_NUMBER);
		return splitByDelimiter(matcher.group(OPERAND_GROUP_NUMBER), customDelimiter);
	}

	private static boolean isBlank(String input) {
		return input == null || input.isEmpty();
	}
}
