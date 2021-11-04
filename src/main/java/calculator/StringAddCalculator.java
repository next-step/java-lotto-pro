package calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private static final String DEFAULT_DELIMITER = ",|:";
	private static final Pattern CUSTOM_DELIMITER = Pattern.compile("//(.)\n(.*)");
	private static final int NUMBER_RANGE_MINIMUM = 0;
	public static final String OUT_OF_MINIMUM_NUMBER_RANGE_ERROR_MSG = "0보다 작은 수는 사용 할 수 없습니다.";

	private StringAddCalculator() {
	}

	public static int splitAndSum(String text) {
		if (isNullOrEmpty(text)) {
			return 0;
		}

		String[] values = split(text);

		int[] numbers = toInts(values);

		return sum(numbers);
	}

	private static String[] split(String text) {
		Matcher m = CUSTOM_DELIMITER.matcher(text);

		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}

		return text.split(DEFAULT_DELIMITER);
	}

	private static int[] toInts(String[] values) {
		int[] numbers = new int[values.length];

		for (int i = 0; i < values.length; i++) {
			int number = Integer.parseInt(values[i]);

			numbers[i] = validateNumberRangeMinimum(number);
		}

		return numbers;
	}

	private static int validateNumberRangeMinimum(int number) {
		if (number < NUMBER_RANGE_MINIMUM) {
			throw new RuntimeException(OUT_OF_MINIMUM_NUMBER_RANGE_ERROR_MSG);
		}

		return number;
	}

	private static int sum(int[] numbers) {
		int sum = 0;

		for (int number : numbers) {
			sum += number;
		}

		return sum;
	}

	private static boolean isNullOrEmpty(String text) {
		return text == null || text.isEmpty();
	}
}
