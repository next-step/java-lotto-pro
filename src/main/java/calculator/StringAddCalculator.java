package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private static final String DEFAULT_DELIMITER = "[,:]";
	private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\\n(.*)";
	private static final int DELIMITER_MATCHER_GROUP = 1;
	private static final int VALUE_MATCHER_GROUP = 2;
	public static int splitAndSum(String strNumbers) {
		if(isNullOrEmpty(strNumbers)) {
			return 0;
		}

		String[] numbers = split(strNumbers);

		return sum(numbers);
	}

	private static boolean isNullOrEmpty(String strNumbers) {
		return strNumbers == null || strNumbers.isEmpty();
	}

	private static int sum(String[] numbers) {
		int total = 0;

		for(String number: numbers) {
			total += Integer.parseInt(number);
		}

		return total;
	}

	private static String[] split(String strNumbers) {
		Matcher matcher = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(strNumbers);

		if (matcher.find()) {
			String customDelimiter = matcher.group(DELIMITER_MATCHER_GROUP);
			return matcher.group(VALUE_MATCHER_GROUP).split(customDelimiter);
		}

		return strNumbers.split(DEFAULT_DELIMITER);
	}
}
