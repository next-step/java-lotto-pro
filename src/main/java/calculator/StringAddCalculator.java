package calculator;

public class StringAddCalculator {

	private static final int NUMBER_RANGE_MINIMUM = 0;

	private StringAddCalculator() {
	}

	public static int splitAndSum(String text) {
		Input input = new Input(text);

		if (input.isNullOrEmpty()) {
			return 0;
		}

		String[] values = input.split();

		int[] numbers = toInts(values);

		return sum(numbers);
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
			throw new RuntimeException(Messages.OUT_OF_MINIMUM_NUMBER_RANGE_ERROR_MSG);
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

}
