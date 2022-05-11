package calculator;

public class StringAddCalculator {
	public static int splitAndSum(String strNumbers) {
		if(isNullOrEmpty(strNumbers)) {
			return 0;
		}

		int number = Integer.parseInt(strNumbers);

		return number;
	}

	private static boolean isNullOrEmpty(String strNumbers) {
		return strNumbers == null || strNumbers.isEmpty();
	}
}
