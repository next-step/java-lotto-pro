import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	private final static String DEFAULT_DELIMITER = ",|:";
	private final static Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

	public static int splitAndSum(String s) {
		if (isNullOrEmpty(s)) {
			return 0;
		}
		final String[] delimiterAndRest = parseDelimiter(s);
		return sum(parseInt(delimiterAndRest[0], delimiterAndRest[1]));
	}

	private static boolean isNullOrEmpty(String s) {
		return (null == s) || s.isEmpty();
	}

	private static String[] parseDelimiter(String s) {
		final Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(s);
		if (matcher.find()) {
			final String customDelimiter = matcher.group(1);
			final String rest = matcher.group(2);
			return new String[]{ customDelimiter, rest };
		}
		return new String[]{ DEFAULT_DELIMITER, s };
	}

	private static int[] parseInt(String delimiter, String s) {
		final String[] tokens = s.split(delimiter);
		final int[] parsedTokens = new int[tokens.length];
		for (int i = 0; i < tokens.length; ++i) {
			parsedTokens[i] = parseNotNegativeInt(tokens[i]);
		}
		return parsedTokens;
	}

	private static int parseNotNegativeInt(String s) {
		final int notNegativeInt = Integer.parseInt(s);
		if (notNegativeInt < 0) {
			throw new RuntimeException();
		}
		return notNegativeInt;
	}

	private static int sum(int[] numbers) {
		int sum = 0;
		for (int number : numbers) {
			sum += number;
		}
		return sum;
	}
}
