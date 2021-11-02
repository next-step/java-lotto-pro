package step2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Splitter {
	private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
	private static final String DELIMITER_REGEX = ",|:";

	public static String[] split(String input) {
		if (input == null || input.isEmpty()) {
			return new String[] {"0"};
		}

		if (input.matches(StringAddCalculator.NUMBER_REGEX)) {
			return new String[] {input};
		}

		return splitByDelimiter(input);
	}

	private static String[] splitByDelimiter(String input) {
		Matcher m = Pattern.compile(CUSTOM_DELIMITER_REGEX).matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}

		return input.split(DELIMITER_REGEX);
	}
}
