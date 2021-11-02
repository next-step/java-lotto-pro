package study;

public class StringAddCalculator {

	public static int splitAndSum(String text) {
		if (isEmpty(text)) {
			return 0;
		}

		return parseInt(text);
	}

	private static int parseInt(String text) {
		return Integer.parseInt(text);
	}

	private static boolean isEmpty(String text) {
		return text == null || text.isEmpty();
	}
}
