package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import calculator.utils.StringUtils;

public class StringSplitter {
	private static final int CUSTOM_DELIMITER_GROUP_INDEX = 1;
	private static final int VALUE_GROUP_INDEX = 2;
	private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
	private static final String CUSTOM_DELIMITER_REGEX = "//(.)\n(.*)";
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_REGEX);

	public static String[] split(String text) {
		if (StringUtils.isEmpty(text)) {
			return new String[]{};
		}

		return splitByDefaultOrCustomDelimiter(text);
	}

	private static String[] splitByDefaultOrCustomDelimiter(String text) {
		Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(text);
		if (matcher.find()) {
			return splitByDelimiter(matcher.group(VALUE_GROUP_INDEX), matcher.group(CUSTOM_DELIMITER_GROUP_INDEX));
		}

		return splitByDelimiter(text, DEFAULT_DELIMITER_REGEX);
	}

	private static String[] splitByDelimiter(String text, String delimiter) {
		return text.split(delimiter);
	}
}
