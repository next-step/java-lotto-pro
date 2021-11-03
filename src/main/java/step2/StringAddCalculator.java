package step2;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {
	private static final String ERROR_MESSAGE = "구분자 혹은 입력 값을 다시 한번 확인해주세요.";
	private static final String BLANK = "";
	private static final String DELIMITER = ",|:";
	private static final String CUSTOM_DELIMITER = "//(.)\n(.*)";

	public static int splitAndSum(String string) {
		if (validateNullOrBlank(string)) {
			return 0;
		}
		return sum(stringArrayToIntArray(split(string)));
	}

	private static boolean validateNullOrBlank(String string) {
		if (string == null || string.equals(BLANK)) {
			return true;
		}
		return false;
	}

	private static String[] split(String string) {
		Matcher matcher = Pattern.compile(CUSTOM_DELIMITER).matcher(string);
		if (useCustomDelimiter(matcher)) {
			return splitByCustomDelimiter(matcher);
		}
		return splitByDelimiter(string);
	}

	private static boolean useCustomDelimiter(Matcher matcher) {
		return matcher.find();
	}

	private static String[] splitByCustomDelimiter(Matcher matcher) {
		String customDelimiter = matcher.group(1);
		return matcher.group(2).split(customDelimiter);
	}

	private static String[] splitByDelimiter(String string) {
		return string.split(DELIMITER);
	}

	private static int[] stringArrayToIntArray(String[] stringArray) {
		try {
			return Arrays.stream(stringArray).mapToInt(Integer::parseInt).toArray();
		} catch (NumberFormatException e) {
			throw new RuntimeException(ERROR_MESSAGE);
		}
	}

	private static int sum(int[] intArray) {
		return Arrays.stream(intArray).sum();
	}
}
