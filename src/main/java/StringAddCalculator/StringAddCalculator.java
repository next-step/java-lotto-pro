package StringAddCalculator;

public class StringAddCalculator {

	public static int splitAndSum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}
		String[] splitInput = splitInput(input,",");
		return calculatorInput(splitInput);
	}

	private static String[] splitInput(String input, String separator) {
		return input.split(separator);
	}

	private static int calculatorInput(String[] splitInput) {
		int result = 0;
		for (String str : splitInput) {
			result += Integer.parseInt(str);
		}
		return result;
	}

}
