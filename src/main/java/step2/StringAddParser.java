package step2;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class StringAddParser {

	private final static String DEFAULT_DELIMITER = ",|:";
	private final static Pattern CUSTOM_DELIMITER_PATTERN = Pattern.compile("//(.)\n(.*)");

	public static List<PositiveNumber> parse(String s) {
		final Matcher matcher = CUSTOM_DELIMITER_PATTERN.matcher(s);
		if (matcher.find()) {
			final String customDelimiter = matcher.group(1);
			final String rest = matcher.group(2);
			return parse(customDelimiter, rest);
		}
		return parse(DEFAULT_DELIMITER, s);
	}

	public static List<PositiveNumber> parse(String delimiter, String s) {
		return Arrays.stream(s.split(delimiter))
			.map(PositiveNumber::from)
			.collect(Collectors.toList());
	}
}
