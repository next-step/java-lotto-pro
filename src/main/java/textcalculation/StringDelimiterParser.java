package textcalculation;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import textcalculation.exception.InvalidDelimiterFormat;

public class StringDelimiterParser {

	private static final String CUSTOM_DELIMITER_NOT_SINGLE_ERROR_MESSAGE = "[ERROR] 커스텀 구분자는 한자리 문자여야 합니다.";
	private static final String CUSTOM_DELIMITER_NUMBER_ERROR_MESSAGE = "[ERROR] 커스텀 구분자는 숫자여야 합니다.";
	private static final String CUSTOM_DELIMITER_EMPTY_ERROR_MESSAGE = "[ERROR] 커스텀 구분자가 빈값입니다.";
	private static final String CUSTOM_DELIMIERS_PATTERN = "//(.*)\n(.*)";
	private static final String BASIC_DELIMITERS = ":|,";
	private static final String EMPTY_STRING_TO_ZERO = "0";
	private static final int SPLIT_CUSTOM_DELIMITER_INDEX = 1;
	private static final int SPLIT_NUMBER_TEXT_INDEX = 2;
	private static final int SINGLE_LETTER_LENGTH = 1;
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile(CUSTOM_DELIMIERS_PATTERN);

	protected static String[] splitText(String text) {
		// Pattern 클래스의 인스턴스 생성 비용이 크기 때문에 매번 생성하는 대신 클래스 변수로 선언하고 재사용
		Matcher m = CUSTOM_DELIMITER_PATTERN.matcher(text);
		if (hasCustomDelimiter(m)) {
			String customDelimiter = m.group(SPLIT_CUSTOM_DELIMITER_INDEX);
			return splitWithDelimiters(m.group(SPLIT_NUMBER_TEXT_INDEX), getDelimitersWithCustom(customDelimiter));
		}
		return splitWithDelimiters(text, BASIC_DELIMITERS);
	}

	private static boolean hasCustomDelimiter(Matcher m) {
		return m.find();
	}

	private static String[] splitWithDelimiters(String text, String basicDelimiters) {
		if (isTextNullOrEmpty(text)) {
			return Arrays.asList(EMPTY_STRING_TO_ZERO).toArray(new String[0]);
		}
		return text.split(basicDelimiters);
	}

	protected static boolean isTextNullOrEmpty(String text) {
		if (isTextNull(text)) {
			return true;
		}

		if (isTextEmpty(text)) {
			return true;
		}

		return false;
	}

	private static boolean isTextNull(String text) {
		if (text == null) {
			return true;
		}
		return false;
	}

	private static boolean isTextEmpty(String text) {
		if (text.isEmpty()) {
			return true;
		}
		return false;
	}

	private static String getDelimitersWithCustom(String customDelimiter) {
		validateCustomDelimiter(customDelimiter);
		return String.join("|", BASIC_DELIMITERS, customDelimiter);
	}

	private static void validateCustomDelimiter(String customDelimiter) {
		if (isEmptyDelimiter(customDelimiter)) {
			throw new InvalidDelimiterFormat(CUSTOM_DELIMITER_EMPTY_ERROR_MESSAGE);
		}

		if (isNotSingleDelimiter(customDelimiter)) {
			throw new InvalidDelimiterFormat(CUSTOM_DELIMITER_NOT_SINGLE_ERROR_MESSAGE);
		}

		if (isNumberDelimiter(customDelimiter.charAt(0))) {
			throw new InvalidDelimiterFormat(CUSTOM_DELIMITER_NUMBER_ERROR_MESSAGE);
		}
	}

	private static boolean isEmptyDelimiter(String delimiter) {
		if (delimiter.isEmpty()) {
			return true;
		}
		return false;
	}

	private static boolean isNotSingleDelimiter(String delimiter) {
		if (delimiter.length() > SINGLE_LETTER_LENGTH) {
			return true;
		}
		return false;
	}

	private static boolean isNumberDelimiter(char delimiter) {
		if (Character.isDigit(delimiter)) {
			return true;
		}
		return false;
	}
}
