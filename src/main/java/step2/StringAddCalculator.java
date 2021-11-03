package step2;

public class StringAddCalculator {
	public static int splitAndSum(String string) {
		if (validateNullOrBlank(string)) {
			return 0;
		}
		return -1;
	}

	private static boolean validateNullOrBlank(String string) {
		if (string == null || string.equals("")) {
			return true;
		}
		return false;
	}
}
