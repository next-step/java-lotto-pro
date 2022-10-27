package calculator;

import static java.util.regex.Pattern.*;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private final static Pattern SPLIT_REGEX_PATTERN = compile("//(.)\n(.*)");
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
			return compile(matcher.group(1))
				.split(matcher.group(2));
		}
		return compile(DEFAULT_SPLIT_REGEX).split(input);
	}

	private static int sum(final String[] input) {
		Positive positive = Arrays.stream(input)
			.map(Positive::new)
			.reduce(Positive::sum)
			.orElse(new Positive());
		return positive.value();
	}
}
