package textcalculation;

import java.util.ArrayList;
import java.util.List;

import textcalculation.exception.NegativeIntegerValueException;

public class StringAddCalculator {

	private static final String NOT_DIGIT_ERROR_MESSAGE = "[ERROR] 구분자 사이에는 숫자만 입력해주세요.";
	private static final String NUMBER_INPUT_NEGATIVE_VALUE_ERROR_MESSAGE = "[ERROR] 0이상의 숫자만 입력해주세요.";

	public static int splitAndSum(String text) {
		if (StringDelimiterParser.isTextNullOrEmpty(text)) {
			return 0;
		}
		String[] splitedText = StringDelimiterParser.splitText(text);
		List<Integer> numbers = convertToNumbers(splitedText);
		return sumNumbers(numbers);
	}

	private static List<Integer> convertToNumbers(String[] splitedText) {
		List<Integer> numbers = new ArrayList<>();

		for (String letter : splitedText) {
			int number = convertToInteger(letter);
			validateNotNegativeInteger(number);
			numbers.add(number);
		}
		return numbers;
	}

	private static int convertToInteger(String letter) {
		try {
			int number = Integer.parseInt(letter);
			return number;
		} catch (NumberFormatException ex) {
			throw new NumberFormatException(NOT_DIGIT_ERROR_MESSAGE);
		}
	}

	private static void validateNotNegativeInteger(int number) {
		if (number < 0) {
			throw new NegativeIntegerValueException(NUMBER_INPUT_NEGATIVE_VALUE_ERROR_MESSAGE);
		}
	}

	private static int sumNumbers(List<Integer> numbers) {
		return numbers.stream().mapToInt(number -> number).sum();
	}
}
