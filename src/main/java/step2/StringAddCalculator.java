package step2;

public class StringAddCalculator {
	private static int number;

	public static int splitAndSum(String string) {
		if (validateNullOrBlank(string)) {
			return 0;
		}
		number = stringToInt(string);
		return number;
	}

	private static boolean validateNullOrBlank(String string) {
		if (string == null || string.equals("")) {
			return true;
		}
		return false;
	}

	private static int stringToInt(String string) {
		try {
			 number = Integer.parseInt(string);
		} catch (NumberFormatException e) {
			throw new RuntimeException("입력된 값은 숫자가 아닙니다.");
		}
		return number;
	}
}
