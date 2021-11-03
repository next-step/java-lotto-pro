import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringCalculator {
	private static final String DEFAULT_DELIMITER_PATTERN = ",|:";
	private static final String CUSTOM_DELIMITER_PATTERN = "(//)(.*)(\\\\n)(.*)";
	private String customDelimiter;
	private String cleanedInput;

	public StringCalculator(String input) {
		cleanedInput = input;

		Matcher matcher = parse(input);
		if (matcher != null) {
			customDelimiter = matcher.group(2);
			cleanedInput = matcher.group(4);
		}
	}

	public int calculate() {
		String delimiterPattern = getDelimiterPattern();
		String[] chunkedList = this.cleanedInput.split(delimiterPattern);
		int sum = 0;
		try {
			sum = sum(chunkedList);
		} catch (Exception e) {
			throw new RuntimeException("The input is not valid");
		}
		return sum;
	}

	private int sum(String[] numbers) {
		int sum = 0;
		for (String num : numbers) {
			int i = Integer.parseInt(num);
			if (i < 0) {
				throw new RuntimeException();
			}
			sum += i;
		}
		return sum;
	}

	private Matcher parse(String input) {
		Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
		Matcher matcher = pattern.matcher(input);
		return matcher.find() ? matcher : null;
	}

	private String getDelimiterPattern() {
		String delimilterPattern = DEFAULT_DELIMITER_PATTERN;
		if (this.customDelimiter != null) {
			delimilterPattern += "|" + customDelimiter;
		}
		return delimilterPattern;
	}
}
