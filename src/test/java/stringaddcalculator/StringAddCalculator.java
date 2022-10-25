package stringaddcalculator;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddCalculator {
	private static final int ZERO = 0;
	private static final String DEFAULT_SPLIT_REGEX = ",|:";
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

	public static int splitAndSum(String text) {
		if (text == null) {
			return ZERO;
		}
		if (text.isEmpty()) {
			return ZERO;
		}
		String[] numbers = splitText(text);

		List<Number> number = Arrays.stream(numbers)
			.map(Number::new)
			.collect(Collectors.toList());

		validateNegative(number);

		Optional<Number> numberOptional = number.stream()
			.reduce(Number::sum);

		return numberOptional.map(Number::getValue).orElse(ZERO);
	}

	private static void validateNegative(List<Number> number) {
		if (number.stream().anyMatch(Number::isNegative)) {
			throw new RuntimeException();
		}
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
}
