package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

	public static final String defaultDelimiter = ",|:";

	public List<Integer> parse(String input) {
		if (isCustomDelimiter(input)) {
			return customSplit(input);
		}
		return defaultSplit(input);
	}

	private List<Integer> customSplit(String input) {
		String numberStr = getCustomNumberStr(input);
		String delimiter = getCustomDelimiter(input);
		if (numberStr == null || delimiter == null) {
			throw new RuntimeException("커스텀 구분 파싱에 실패했습니다");
		}
		return split(numberStr, delimiter);
	}

	private List<Integer> defaultSplit(String input) {
		return split(input, defaultDelimiter);
	}

	private List<Integer> split(String input, String delimiter) {
		List<Integer> numbers = new ArrayList<>();
		String[] splits = input.split(delimiter);
		for (String s : splits) {
			numbers.add(parseInteger(s));
		}
		return numbers;
	}

	private int parseInteger(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new RuntimeException("숫자가 아닙니다");
		}
	}

	private String getCustomDelimiter(String input) {
		Matcher m = getCustomMatcher(input);
		if (m.find()) {
			return m.group(1);
		}
		return null;
	}

	private String getCustomNumberStr(String input) {
		Matcher m = getCustomMatcher(input);
		if (m.find()) {
			return m.group(2);
		}
		return null;
	}

	private boolean isCustomDelimiter(String input) {
		Matcher m = getCustomMatcher(input);
		return m.find();
	}

	private Matcher getCustomMatcher(String input) {
		return Pattern.compile("//(.)\n(.*)").matcher(input);
	}

}
