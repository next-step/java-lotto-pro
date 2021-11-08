import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Statement {
	private static final String DEFAULT_DELIMITER_REGEX = "[,:]";
	private static final String CUSTOM_DELIMITER_PATTERN = "//(.)\n(.*)";
	private final String statement;

	public Statement(String statement) {
		this.statement = statement;
	}

	public int calculate() {
		if (statement == null || statement.isEmpty()) {
			return 0;
		}

		if (statement.length() == 1) {
			return Integer.parseInt(statement);
		}

		Matcher match = Pattern.compile(CUSTOM_DELIMITER_PATTERN).matcher(statement);
		if (match.find()) {
			return sumWithExpression(match.group(2), match.group(1));
		}

		return sumWithExpression(statement, DEFAULT_DELIMITER_REGEX);
	}

	private int sumWithExpression(String expression, String delimiter) {
		String[] splittedByDelimiter = expression.split(delimiter);
		Numbers numbers = new Numbers(splittedByDelimiter);
		return numbers.summarize().getNumber();
	}
}
