package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringInput {

	private static final String DELIMITERS = ",|:";
	private static final String CUSTOM_DELIMITER_BOUNDARY = "//(.*)\n(.*)";
	private static final String EXCEPTION_MESSAGE = "양의 숫자만 입력 가능합니다.";

	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMITER_BOUNDARY);

	private String input;

	public StringInput(String input) {
		setInput(input);
	}

	private void setInput(String input) {
		if (isNull(input) || isEmpty(input)) {
			this.input = "0";
			return;
		}
		this.input = input;
	}

	public String[] separate() {
		if (input.length() == 1) {
			return oneSeparate();
		}
		return delimiterSeparate();
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

	private String[] delimiterSeparate() {
		Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(input);
		 if (m.find()) {
			return validSeparate(m.group(2).split(m.group(1)));
		}
		return validSeparate(input.split(DELIMITERS));
	}

	private String[] validSeparate(String[] splits) {;
		validString(splits);
		return splits;
	}

	private String[] oneSeparate() {
		isNumber(input);
		return input.split("");
	}

	private void validString(String[] number) {
		for (String s : number) {
			isNumber(s);
		}
	}

	private void isNumber(String number) {
		try {
			int i = Integer.parseInt(number);
			isPositiveNumber(i);
		}catch (NumberFormatException e) {
			throw new RuntimeException(EXCEPTION_MESSAGE);
		}
	}

	private void isPositiveNumber(int i) {
		if (i < 0) {
			throw new RuntimeException(EXCEPTION_MESSAGE);
		}
	}
}
