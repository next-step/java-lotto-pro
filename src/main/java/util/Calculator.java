package util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import model.Number;

public class Calculator {
	private static final String CUSTOM_REGEX = "//(.)\n(.*)";
	private static final String BASIC_REGEX = ",|:";
	private static final int GROUP_DELIMITER_NO = 1;
	private static final int GROUP_NUMBERS_NO = 2;

	private static Pattern customRegexPattern;
	
	private Calculator() {
	}

	public static int sum(String value) {
		if (isEmpty(value)) {
			return 0;
		}

		List<Number> list = new ArrayList<>();
		for (String number : split(value)) {
			list.add(new Number(number));
		}

		return list.stream().mapToInt(Number::getNumber).sum();
	}

	private static String[] split(String value) {
		Matcher matcher = getCustomRegexPattern().matcher(value);
		if (matcher.find()) {
			String customDelimiter = matcher.group(GROUP_DELIMITER_NO);
			return matcher.group(GROUP_NUMBERS_NO).split(customDelimiter);
		}

		return value.split(BASIC_REGEX);
	}

	private static boolean isEmpty(String value) {
		return value == null || value.isEmpty();
	}

	private static Pattern getCustomRegexPattern() {
		if (customRegexPattern == null) {
			customRegexPattern = Pattern.compile(CUSTOM_REGEX);
		}
		return customRegexPattern;
	}
}
