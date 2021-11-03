package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private final static String DEFAULT_DELIMITER = ",|:";
	private final static Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

	public static int splitAndSum(String s) {
		if (isNullOrEmpty(s)) {
			return 0;
		}
		final String[] delimiterAndRest = parseDelimiterAndRest(s);
		return sum(parseNumbers(delimiterAndRest[0], delimiterAndRest[1]));
	}

	private static boolean isNullOrEmpty(String s) {
		return (null == s) || s.isEmpty();
	}

	private static String[] parseDelimiterAndRest(String s) {
		final Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(s);
		if (matcher.find()) {
			final String customDelimiter = matcher.group(1);
			final String rest = matcher.group(2);
			return new String[]{ customDelimiter, rest };
		}
		return new String[]{ DEFAULT_DELIMITER, s };
	}

	private static PositiveNumber[] parseNumbers(String delimiter, String s) {
		final String[] tokens = s.split(delimiter);
		final PositiveNumber[] parsedTokens = new PositiveNumber[tokens.length];
		for (int i = 0; i < tokens.length; ++i) {
			parsedTokens[i] = PositiveNumber.from(tokens[i]);
		}
		return parsedTokens;
	}

	private static int sum(PositiveNumber[] numbers) {
		int sum = 0;
		for (PositiveNumber number : numbers) {
			sum += number.get();
		}
		return sum;
	}
}
