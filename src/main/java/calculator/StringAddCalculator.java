package calculator;

public class StringAddCalculator {

	public static final int ZERO = 0;

	public static int splitAndSum(String text) {
		if (isEmpty(text)) {
			return ZERO;
		}

		return new Numbers(Separator.split(text)).sum();
	}

	private static boolean isEmpty(String text) {
		return text == null || text.isEmpty();
	}
}
