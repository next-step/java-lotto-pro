package calculator;

public class IntArrayConverter {
	private static final int NUMBER_RANGE_MINIMUM = 0;

	private IntArrayConverter() {
	}

	public static int[] toInts(String[] values) {
		validateValuesNotNullOrEmpty(values);

		int[] numbers = new int[values.length];

		for (int i = 0; i < values.length; i++) {
			int number = Integer.parseInt(values[i]);

			numbers[i] = validateNumberRangeMinimum(number);
		}

		return numbers;
	}

	private static void validateValuesNotNullOrEmpty(String[] values) {
		if (values == null || values.length == 0) {
			throw new ValuesNotConvertibleException();
		}
	}

	private static int validateNumberRangeMinimum(int number) {
		if (number < NUMBER_RANGE_MINIMUM) {
			throw new NumberOutOfRangeException();
		}

		return number;
	}
}
