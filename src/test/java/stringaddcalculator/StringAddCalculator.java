package stringaddcalculator;

import java.util.Arrays;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	public static final int ZERO = 0;
	public static final String SPLIT_REGEX = ",|:";

	public static int splitAndSum(String text) {
		if (text == null) {
			return ZERO;
		}
		if (text.isEmpty()) {
			return ZERO;
		}

		String[] numbers;
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(text);
		if (m.find()) {
			String customDelimiter = m.group(1);
			numbers = m.group(2).split(customDelimiter);
		} else {
			numbers = text.split(SPLIT_REGEX);
		}

		OptionalInt any = Arrays.stream(numbers)
			.mapToInt(Integer::parseInt)
			.filter(value -> value < 0)
			.findAny();
		if (any.isPresent()) {
			throw new RuntimeException();
		}

		return Arrays.stream(numbers)
			.mapToInt(Integer::parseInt)
			.sum();
	}
}
