package stringaddcalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputSplitter {
	private static final String DEFAULT_SPLIT_REGEX = ",|:";
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

	public static String[] splitText(String input) {
		Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			String targetText = m.group(2);
			return targetText.split(customDelimiter);
		}
		return input.split(DEFAULT_SPLIT_REGEX);
	}
}
