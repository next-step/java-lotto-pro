package calculator;

public class StringAddCalculator {
	private static final String DEFAULT_SEPARATOR = ",|:";

	public static int splitAndSum(String text) {
		if (isEmpty(text)) {
			return 0;
		}

		return Integer.parseInt(text);
	}

	public static String[] splitText(String text) {
		return text.split(DEFAULT_SEPARATOR);
	}

	public static void checkNumber(String text) {
		int number = -1;
		try {
			number = Integer.parseInt(text);
		} catch (NumberFormatException e) {
			throw new RuntimeException("숫자가 아닙니다.");
		}
		if (number < 0) {
			throw new RuntimeException("음수입니다.");
		}
	}

	public static boolean isEmpty(String text) {
		if (text == null || text.trim().isEmpty()) {
			return true;
		}
		return false;
	}

}
