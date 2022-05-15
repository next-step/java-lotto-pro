package lotto.domain;

import java.util.Objects;

public class Number {
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;
	private final String INVALID_VALUE = "1~45 사이의 숫자만 가능합니다.";

	private int number;

	public Number(int number) {
		validNumber(number);
		this.number = number;
	}

	private void validNumber(int number) {
		if(number < MIN_NUMBER || number > MAX_NUMBER) {
			throw new IllegalArgumentException(INVALID_VALUE);
		}
	}

	public int getNumber() {
		return number;
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
