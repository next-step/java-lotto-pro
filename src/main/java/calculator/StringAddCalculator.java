package calculator;

import java.util.Arrays;
import java.util.List;

import calculator.constant.ErrorMessage;
import calculator.utils.StringToIntegerParser;
import calculator.utils.StringUtils;

public class StringAddCalculator {
	private static final int SUM_INIT_VALUE = 0;
	private static final String POSITIVE_NUMBERS_REGEX = "^[0-9]+$";

	public static int splitAndSum(String text) {
		if (StringUtils.isEmpty(text)) {
			return SUM_INIT_VALUE;
		}

		String[] splitValues = StringSplitter.split(text);
		validateConsistOfPositiveNumber(splitValues);
		List<Integer> numbers = StringToIntegerParser.parseNumbers(splitValues);

		return SUM_INIT_VALUE;
	}

	private static void validateConsistOfPositiveNumber(String[] splitValues) {
		boolean isAllPositiveNumbers = Arrays.stream(splitValues)
											 .allMatch(input -> input.matches(POSITIVE_NUMBERS_REGEX));
		if (!isAllPositiveNumbers) {
			throw new RuntimeException(ErrorMessage.INVALID_STRING_INPUT);
		}
	}
}
