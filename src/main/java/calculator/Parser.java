package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

	public static final String defaultDelimiter = ",|:";
	public static final String customRegex = "//(.)\n(.*)";
	public static final String numberFormatRegex = "^[0-9]";

	public static Numbers parse(String input) {
		if (isCustomDelimiter(input)) {
			return customSplit(input);
		}
		return split(input, defaultDelimiter);
	}

	private static Numbers customSplit(String input) {
		Matcher m = getCustomMatcher(input);
		if (m.find()) {
			String delimiter = m.group(1);
			String numberStr = m.group(2);
			return split(numberStr, delimiter);
		}
		throw new RuntimeException(ErrorMessage.CUSTOM_SPLIT_ERROR.message());
	}

	private static Numbers split(String input, String delimiter) {
		Numbers numbers = new Numbers();
		String[] splits = input.split(delimiter);
		for (String s : splits) {
			numbers.add(parseNumber(s));
		}
		return numbers;
	}

	private static int parseNumber(String str) {
		Matcher matcher = Pattern.compile(numberFormatRegex).matcher(str);
		if (matcher.find()) {
			return Integer.parseInt(str);
		}
		throw new RuntimeException(ErrorMessage.PARSE_NUMBER_ERROR.message());
	}

	private static boolean isCustomDelimiter(String input) {
		Matcher m = getCustomMatcher(input);
		return m.find();
	}

	private static Matcher getCustomMatcher(String input) {
		return Pattern.compile(customRegex).matcher(input);
	}

}
