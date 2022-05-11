package calculator;

public class StringAddCalculator {
	private static final String DELIMITER = "[,:]";
	public static int splitAndSum(String strNumbers) {
		if(isNullOrEmpty(strNumbers)) {
			return 0;
		}

		String[] numbers = strNumbers.split(DELIMITER);

		return sum(numbers);
	}

	private static boolean isNullOrEmpty(String strNumbers) {
		return strNumbers == null || strNumbers.isEmpty();
	}

	private static int sum(String[] numbers) {
		int total = 0;

		for(String number: numbers) {
			total += Integer.parseInt(number);
		}

		return total;
	}
}
