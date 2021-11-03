package calculator;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Split {
	private static final String NORMAL_TOKEN = "[,:]";
	private static final Pattern CUSTOM_TOKEN_PATTERN = Pattern.compile("//(.)\n(.*)");
	private static final String NULL_STRING_ARRAY_VALUE = "0";
	private static final String WRONG_INPUT_ERROR_MESSAGE = "숫자가 아닌 입력 값이 존재합니다.";
	private static final String NEGATIVE_NUMBER_INPUT_ERROR_MESSAGE = "입력 값 중 음수가 존재합니다.";

	private String[] stringArray;
	private int[] intArray;

	public Split(String input) {
		this.stringArray = validNullInput(input);
		convertStringArrayToIntArray();
	}

	private String[] validNullInput(String input) {
		if (input == null || input.isEmpty()) {
			return new String[] {NULL_STRING_ARRAY_VALUE};
		}
		return splitCustomToken(input);
	}

	private String[] splitCustomToken(String input) {
		Matcher matcher = CUSTOM_TOKEN_PATTERN.matcher(input);
		if (matcher.find()) {
			String customToken = matcher.group(1);
			return matcher.group(2).split(customToken);
		}
		return splitNormalToken(input);
	}

	public String[] getStringArray() {
		return stringArray;
	}

	public int[] getIntArray() {
		return intArray;
	}

	private String[] splitNormalToken(String input) {
		return input.split(NORMAL_TOKEN);
	}

	public void convertStringArrayToIntArray() {
		try {
			this.intArray = Arrays.stream(stringArray).mapToInt(s -> isNegativeNumber(s)).toArray();
		} catch (NumberFormatException numberFormatException) {
			throw new RuntimeException(WRONG_INPUT_ERROR_MESSAGE);
		}
	}

	private int isNegativeNumber(String input) {
		int number = Integer.parseInt(input);
		if (number < 0) {
			throw new RuntimeException(NEGATIVE_NUMBER_INPUT_ERROR_MESSAGE);
		}
		return number;
	}
}
