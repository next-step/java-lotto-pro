package lotto.util;

public class SplitUtil {
	private final static String SEPARATOR = ",";
	private final static String REPLACE_REGEX = "\\p{Z}";
	private final static String EMPTY_STRING = "";

	public static String[] splitInputNumbers(String input) {
		return input.replaceAll(REPLACE_REGEX, EMPTY_STRING).split(SEPARATOR);
	}
}
