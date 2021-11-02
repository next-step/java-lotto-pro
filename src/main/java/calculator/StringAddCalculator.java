package calculator;

public class StringAddCalculator {

	private static final String DEFAULT_DELIMITER = ",|:";

	public static int splitAndSum(String text) {
		if (isNullOrEmpty(text))
			return 0;

		String[] values = text.split(DEFAULT_DELIMITER);
		int[] numbers = toInts(values);

		return sum(numbers);
	}

	private static int[] toInts(String[] values) {
		int[] numbers = new int[values.length];

		for (int i = 0; i < values.length; i++) {
			numbers[i] = Integer.parseInt(values[i]);
		}

		return numbers;
	}

	private static int sum(int[] numbers) {
		int sum = 0;

		for (int number: numbers) {
			sum += number;
		}

		return sum;
	}

	private static boolean isNullOrEmpty(String text) {
		return text == null || text.isEmpty();
	}
}
