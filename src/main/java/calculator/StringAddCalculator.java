package calculator;

public class StringAddCalculator {

	private StringAddCalculator() {
	}

	public static int splitAndSum(String text) {
		Input input = new Input(text);

		if (input.isNullOrEmpty()) {
			return 0;
		}

		String[] values = input.split();

		int[] numbers = IntArrayConverter.toInts(values);

		return sum(numbers);
	}

	private static int sum(int[] numbers) {
		int sum = 0;

		for (int number : numbers) {
			sum += number;
		}

		return sum;
	}
}
