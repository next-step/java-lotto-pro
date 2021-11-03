package calculator;

public class ValidationUtils {
	private static final int MINIMUM_NUMBER = 0;
	private static final String ERROR_IS_NOT_IN_RANGE = MINIMUM_NUMBER + "보다 큰 숫자여야 합니다.";
	private static final String ERROR_IS_NOT_NUMBER = "숫자가 아닙니다.";

	public static void checkNumber(String[] numbers) {
		for (String number : numbers) {
			try {
				checkMinimum(Integer.parseInt(number));
			} catch (NumberFormatException e) {
				throw new RuntimeException(ERROR_IS_NOT_NUMBER);
			}
		}
	}

	private static void checkMinimum(int number) {
		if (number < MINIMUM_NUMBER) {
			throw new RuntimeException(ERROR_IS_NOT_IN_RANGE);
		}
	}

	public static boolean isEmpty(String text) {
		if (text == null || text.trim().isEmpty()) {
			return true;
		}
		return false;
	}

}
