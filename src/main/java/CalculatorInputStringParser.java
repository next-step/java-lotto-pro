import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class CalculatorInputStringParser {
	private static final Pattern PATTERN_DEFAULT_DELIMITERS = Pattern.compile("[,:]");
	private static final Pattern PATTERN_FOR_CAPTURE_CUSTOM_DELIMITER_AND_NUMBERS = Pattern.compile("//(.)\n(.*)");

	public static List<Integer> parse(String inputString) {
		Matcher matcher = PATTERN_FOR_CAPTURE_CUSTOM_DELIMITER_AND_NUMBERS.matcher(inputString);
		if (matcher.find()) {
			return getIntegersWhenHasCustomDelimiter(matcher);
		}
		return getIntegers(inputString);
	}

	private static List<Integer> getIntegers(String inputString) {
		String[] tokens = PATTERN_DEFAULT_DELIMITERS.split(inputString);
		return Arrays.stream(tokens).map(Integer::parseInt).collect(Collectors.toList());
	}

	private static List<Integer> getIntegersWhenHasCustomDelimiter(Matcher matcher) {
		String customDelimiter = matcher.group(1);
		String[] tokens = matcher.group(2).split(customDelimiter);
		return Arrays.stream(tokens).map(Integer::parseInt).collect(Collectors.toList());
	}
}
