package calculator;

public class StringAddCalculator {
	public static int splitAndSum(String text) {
		if (isNullOrEmpty(text))
			return 0;

		String[] values = text.split(",");
		int sum = 0;
		for (String value: values) {
			sum += Integer.parseInt(value);
		}

		return sum;
	}

	private static boolean isNullOrEmpty(String text) {
		return text == null || text.isEmpty();
	}
}
