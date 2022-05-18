package calculator.domain;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Number {
	private final static String INVALID_NUMBER = "0 이상 숫자만 입력 가능합니다.";
	private final static Pattern pattern = Pattern.compile("[0-9]+");

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
		Matcher matcher = pattern.matcher(number);

		if(!matcher.find()) {
			throw new IllegalArgumentException(INVALID_NUMBER);
		}
	}

	private static boolean isNullOrEmpty(String strNumbers) {
		return strNumbers == null || strNumbers.isEmpty();
	}

	public int getNumber() {
		return number;
	}

	public static Number sum(Number a, Number b) {
		return new Number(a.number + b.number);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Number number1 = (Number)o;
		return number == number1.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
