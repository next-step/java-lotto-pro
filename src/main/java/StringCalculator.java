import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import util.Split;
import wrapper.Delimiter;

public class StringCalculator {
	private static final String DEFAULT_DELIMITER_PATTERN = ",|:";
	private static final String CUSTOM_DELIMITER_PATTERN = "(//)(.*)(\\\\n)(.*)";
	private String customDelimiter;
	private String cleanedInput;

	public StringCalculator(String input) {
		cleanedInput = input;

		Matcher matcher = parse(input);
		if(matcher != null) {
			customDelimiter = matcher.group(2);
			cleanedInput = matcher.group(4);
		}
	}

	public int calculate() {
		String delimiterPattern = getDelimiterPattern();
		String[] chunkedList = Split.split(this.cleanedInput, delimiterPattern);
		return Arrays.stream(chunkedList).mapToInt(x -> x.isEmpty() ? 0 : Integer.parseInt(x)).sum();
	}

	private Matcher parse(String input) {
		Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
		Matcher matcher = pattern.matcher(input);
		return matcher.find() ? matcher : null;
	}

	private String getDelimiterPattern() {
		String delimilterPattern = DEFAULT_DELIMITER_PATTERN;
		if (this.customDelimiter != null) {
			delimilterPattern += "|" + customDelimiter;
		}
		return delimilterPattern;
	}
}
