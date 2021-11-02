package step2;

public class StringAddCalculator {
	private static final String NUMBER_REGEX = "^[0-9]+$";

	public static int splitAndSum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}

		if (input.matches(NUMBER_REGEX)) {
			return Integer.parseInt(input);
		}

		return 0;
	}
}
