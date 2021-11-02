package calculator;

import java.util.Arrays;

public class StringAddCalculator {
	private static final String DEFAULT_SEPARATOR = ",|:";

	public static int splitAndSum(String text) {
		if (isEmpty(text)) {
			return 0;
		}
		String[] numbers = splitText(text);
		checkNumber(numbers);

		return sum(numbers);
	}

	public static String[] splitText(String text) {
		return text.split(DEFAULT_SEPARATOR);
	}

	public static void checkNumber(String[] numbers) {
		for (String number : numbers) {
			try {
				if (Integer.parseInt(number) < 0) {
					throw new RuntimeException("음수입니다.");
				}
			} catch (NumberFormatException e) {
				throw new RuntimeException("숫자가 아닙니다.");
			}
		}
	}

	public static boolean isEmpty(String text) {
		if (text == null || text.trim().isEmpty()) {
			return true;
		}
		return false;
	}

	public static int sum(String[] numbers) {
		return Arrays.stream(numbers).mapToInt(Integer::parseInt).sum();
	}

}
