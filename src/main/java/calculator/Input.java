package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Input {

	private static final String DEFAULT_DELIMITER = ",|:";
	private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

	private final String input;

	public Input(final String text) {
		input = text;
	}

	public boolean isNullOrEmpty() {
		return input == null || input.isEmpty();
	}

	public String[] split() {
		Matcher m = CUSTOM_DELIMITER.matcher(input);

		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}

		return input.split(DEFAULT_DELIMITER);
	}
}
