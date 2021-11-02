public class StringAddCalculator {

	private final static String DEFAULT_DELIMITER = ",|:";

	public static int splitAndSum(String s) {
		if (isNullOrEmpty(s)) {
			return 0;
		}
		return sum(parse(s, DEFAULT_DELIMITER));
	}

	private static boolean isNullOrEmpty(String s) {
		return (null == s) || s.isEmpty();
	}

	private static int[] parse(String s, String delimiter) {
		final String[] tokens = s.split(delimiter);
		final int[] parsedTokens = new int[tokens.length];
		for (int i = 0; i < tokens.length; ++i) {
			parsedTokens[i] = Integer.parseInt(tokens[i]);
		}
		return parsedTokens;
	}

	private static int sum(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}
}
