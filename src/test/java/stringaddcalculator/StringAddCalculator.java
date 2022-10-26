package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private static final String DEFAULT_SPLIT_REGEX = ",|:";
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

	public static int splitAndSum(String text) {
		if (isNullOrEmpty(text)) {
			return Number.ZERO;
		}

		Numbers numbers = new Numbers(splitText(text));
		validateNegative(numbers);

		Number result = numbers.sum();
		return result.getValue();
	}

	private static String[] splitText(String text) {
		Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
		if (m.find()) {
			String customDelimiter = m.group(1);
			String targetText = m.group(2);
			return targetText.split(customDelimiter);
		}
		return text.split(DEFAULT_SPLIT_REGEX);
	}

	private static void validateNegative(Numbers numbers) {
		if (numbers.containsNegative()) {
			throw new RuntimeException();
		}
	}

	private static boolean isNullOrEmpty(String text) {
		if (text == null) {
			return true;
		}
		if (text.isEmpty()) {
			return true;
		}
		return false;
	}
}
