package StringAddCalculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringAddCalculator {

	public static int splitAndSum(String input) {
		if (input == null || input.isEmpty()) {
			return 0;
		}
		String[] splitInput = splitInput(input);
		return calculatorInput(splitInput);
	}

	private static String[] splitInput(String input) {
		Matcher m = Pattern.compile("//(.)\n(.*)").matcher(input);
		if (m.find()) {
			String customDelimiter = m.group(1);
			return m.group(2).split(customDelimiter);
		}
		return input.split(",|:");
	}

	private static int calculatorInput(String[] splitInput) {
		int result = 0;
		for (String str : splitInput) {
			result += checkPositiveNum(str);
		}
		return result;
	}

	private static int checkPositiveNum(String str) {
		int num = checkNum(str);
		if(num < 0) {
			throw new IllegalArgumentException("[Error] 입력 값이 양수가 아닙니다.");
		}
		return num;
	}

	private static int checkNum(String str) {
		try {
			return Integer.parseInt(str);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("[Error] 입력 값이 숫자가 아닙니다.");
		}
	}

}
