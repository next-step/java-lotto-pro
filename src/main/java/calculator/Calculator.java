package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Calculator {
	private static final String DELIMITERS = ",|:";
	private static final String CUSTOM_DELIMITER_BOUNDARY = "//(.*)\\n(.*)";
	private static final String NUMBER_REG_EXP = "[0-9]+";

	private String input;

	public Calculator(String input) {
		if (isNull(input) || isEmpty(input)) {
			this.input = "0";
			return;
		}
		validation(input);
		this.input = input;
	}

	private void validation(String input) {
		/**
		 * @TODO
		 *
		 * 0, 양의 정수을 제외한 다른 값이 들어오는 경우 runtime exception
		 */
	}

	private Matcher patternMatcher(String regexp, String input) {
		return Pattern.compile(regexp).matcher(input);
	}

	public int getSum() {
		if (input.length() == 1) {
			return Integer.parseInt(input);
		}
		String[] tokens = separate();
		return sum(tokens);
	}

	private int sum(String[] numbers) {
		return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
	}

	private String[] separate() {
		Matcher m = patternMatcher(CUSTOM_DELIMITER_BOUNDARY, input);
		if (m.find()) {
			return customDelimiterSeparate(m);
		}
		return input.split(DELIMITERS);
	}

	private String[] customDelimiterSeparate(Matcher matcher) {
		return matcher.group(2).split(matcher.group(1));
	}

	private boolean isNull(String input) {
		if (input == null) {
			return true;
		}
		return false;
	}

	private boolean isEmpty(String input) {
		if (input.isEmpty()) {
			return true;
		}
		return false;
	}
}
