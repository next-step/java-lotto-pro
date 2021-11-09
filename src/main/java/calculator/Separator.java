package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Separator {
	private static final String DEFAULT_DELIMITER = ",|:";
	private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");

	private Separator() {
	}

	public static String[] split(String input) {
		validateInputNotNullOrEmpty(input);

		Matcher m = CUSTOM_DELIMITER.matcher(input);

		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}

		return input.split(DEFAULT_DELIMITER);
	}

	private static void validateInputNotNullOrEmpty(String input) {
		if (input == null || input.isEmpty()) {
			throw new ValueNotSplittableException();
		}
	}
}
