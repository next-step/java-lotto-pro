package step2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddParser {

	private final static String DEFAULT_DELIMITER = ",|:";
	private final static Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

	public static Result parse(String s) {
		final Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(s);
		if (matcher.find()) {
			final String customDelimiter = matcher.group(1);
			final String rest = matcher.group(2);
			return Result.from(customDelimiter, rest);
		}
		return Result.from(DEFAULT_DELIMITER, s);
	}

	static class Result {
		private final List<PositiveNumber> positiveNumbers;

		private Result(List<PositiveNumber> positiveNumbers) {
			this.positiveNumbers = positiveNumbers;
		}

		public List<PositiveNumber> getPositiveNumbers() {
			return positiveNumbers;
		}

		public static Result from(String delimiter, String s) {
			return new Result(Arrays.stream(s.split(delimiter))
				.map(PositiveNumber::from)
				.collect(Collectors.toList()));
		}
	}
}
