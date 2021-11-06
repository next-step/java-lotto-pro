package utility;

import java.util.regex.Pattern;

import model.common.string.StringDelimiterFinder;
import model.common.string.StringDelimiters;
import model.common.string.number.StringNumberSeparator;
import model.common.string.number.StringNumbers;

public final class StringAddCalculator {

	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
	private static final String COMMA_DELIMITER = ",";
	private static final String COLON_DELIMITER = ":";

	private StringAddCalculator() {
		throw new AssertionError();
	}

	public static int splitAndSum(String target) {
		return stringNumbers(target).sum();
	}

	private static StringNumbers stringNumbers(String target) {
		StringDelimiterFinder finder = StringDelimiterFinder.of(CUSTOM_DELIMITER_PATTERN, target);
		if (finder.hasDelimiter()) {
			return StringNumberSeparator.from(StringDelimiters.of(finder.delimiter()))
				.separate(finder.targetWithoutDelimiterPattern());
		}
		return StringNumberSeparator.from(StringDelimiters.of(COMMA_DELIMITER, COLON_DELIMITER)).separate(target);
	}
}
