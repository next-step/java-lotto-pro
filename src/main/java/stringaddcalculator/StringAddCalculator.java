package stringaddcalculator;

import stringaddcalculator.exception.NegativeNumberException;
import stringaddcalculator.exception.NotNumberException;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
	private static final int ZERO_NUMBER = 0;
	private static final Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");
	private static final int DELIMITER_GROUP_NUMBER = 1;
	private static final int OPERAND_GROUP_NUMBER = 2;
	private static final String NEGATIVE_NUMBER_EXCEPTION_MESSAGE = "음수를 입력할 수 없습니다.";
	private static final String NOT_NUMBER_EXCEPTION_MESSAGE = "숫자가 아닌 문자가 입력되었습니다.";


	private StringAddCalculator() {
		throw new AssertionError("초기화 할 수 없는 클래스입니다.");
	}

	public static int splitAndSum(String input) {
		if (isBlank(input)) {
			return ZERO_NUMBER;
		}
		String[] strings = split(input);
		return sum(strings);
	}

	private static int sum(String[] strings) {
		return Arrays.stream(strings)
			.mapToInt(StringAddCalculator::validatedNumber)
			.sum();
	}

	private static int validatedNumber(String input) {
		int number = parseInt(input);
		validateNegativeNumber(number);
		return number;
	}

	private static void validateNegativeNumber(int number) {
		if (number < ZERO_NUMBER) {
			throw new NegativeNumberException(NEGATIVE_NUMBER_EXCEPTION_MESSAGE);
		}
	}

	private static int parseInt(String input) {
		int number;
		try {
			number = Integer.parseInt(input);
		} catch (NumberFormatException e) {
			throw new NotNumberException(NOT_NUMBER_EXCEPTION_MESSAGE);
		}
		return number;
	}

	private static String[] split(String input) {
		Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(input);
		if (matcher.find()) {
			return splitByCustomDelimiter(matcher);
		}
		return splitByDelimiter(input, DEFAULT_DELIMITER_REGEX);
	}

	private static String[] splitByDelimiter(String input, String defaultDelimiterRegex) {
		return input.split(defaultDelimiterRegex);
	}

	private static String[] splitByCustomDelimiter(Matcher matcher) {
		String customDelimiter = matcher.group(DELIMITER_GROUP_NUMBER);
		return splitByDelimiter(matcher.group(OPERAND_GROUP_NUMBER), customDelimiter);
	}

	private static boolean isBlank(String input) {
		return input == null || input.isEmpty();
	}
}
