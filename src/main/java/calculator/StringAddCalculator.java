package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.domain.Numbers;

public class StringAddCalculator {
	private static final String DEFAULT_DELIMITER = "[,:]";
	private static final int DELIMITER_MATCHER_GROUP = 1;
	private static final int VALUE_MATCHER_GROUP = 2;

	private final static Pattern pattern = Pattern.compile("//(.)\n(.*)");

	public static int splitAndSum(String strNumbers) {
		String[] numbers = split(strNumbers);

		return sum(numbers);
	}

	private static int sum(String[] strNumbers) {
		Numbers numbers = new Numbers(strNumbers);

		return numbers.totalSum();
	}

	private static String[] split(String strNumbers) {
		Matcher matcher = pattern.matcher(strNumbers);

		if (matcher.find()) {
			String customDelimiter = matcher.group(DELIMITER_MATCHER_GROUP);
			return matcher.group(VALUE_MATCHER_GROUP).split(customDelimiter);
		}

		return strNumbers.split(DEFAULT_DELIMITER);
	}
}
