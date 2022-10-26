package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private final static Pattern SPLIT_REGEX_PATTERN = Pattern.compile("//(.)\n(.*)");
	private final static String DEFAULT_SPLIT_REGEX = "[,:]";

	public static int calculate(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}
		return sum(split(input));
	}

	private static String[] split(final String input) {
		Matcher matcher = SPLIT_REGEX_PATTERN.matcher(input);
		if (matcher.find()) {
			String customDelimiter = matcher.group(1);
			String string = matcher.group(2);
			return string.split(customDelimiter);
		}
		return input.split(DEFAULT_SPLIT_REGEX);
	}

	private static int sum(final String[] input) {
		Positive positive = Arrays.stream(input)
			.map(Positive::new)
			.reduce(Positive::sum)
			.orElse(new Positive());
		return positive.value();
	}
}
