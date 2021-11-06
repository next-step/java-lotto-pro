package wrapper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorParser {
	private static final String DEFAULT_DELIMITER_PATTERN = ",|:";
	private static final String CUSTOM_DELIMITER_PATTERN = "(//)(.*)(\\\\n)(.*)";

	private String delimiter;
	private String cleanedInput;

	public CalculatorParser(String input) {
		this.delimiter = DEFAULT_DELIMITER_PATTERN;
		this.cleanedInput = input;

		Matcher matcher = parse(input);
		if (matcher.find()) {
			this.delimiter += "|" + matcher.group(2);
			this.cleanedInput = matcher.group(4);
		}
	}

	private static Matcher parse(String input) {
		Pattern pattern = Pattern.compile(CUSTOM_DELIMITER_PATTERN);
		return pattern.matcher(input);
	}

	public String getDelimiter() {
		return this.delimiter;
	}

	public String getInput() {
		return this.cleanedInput;
	}
}
