package calculator.domain;

import java.util.regex.Pattern;

public class Number {
	private final static String NUMBER_REGEX = "[0-9]+";
	private final static String INVALID_NUMBER = "0 이상 숫자만 입력 가능합니다.";

	private int number;

	public Number(String number) {
		this(Number.parse(number));
	}

	public Number(int number) {
		this.number = number;
	}

	private static int parse(String number) {
		if(isNullOrEmpty(number)) {
			return 0;
		}

		valid(number);
		return Integer.parseInt(number);
	}

	private static void valid(String number) {
		if(!Pattern.matches(NUMBER_REGEX, number)) {
			throw new RuntimeException(INVALID_NUMBER);
		}
	}

	private static boolean isNullOrEmpty(String strNumbers) {
		return strNumbers == null || strNumbers.isEmpty();
	}

	public boolean isEqualTo(int number) {
		return this.number == number;
	}

	public int getNumber() {
		return number;
	}
}
