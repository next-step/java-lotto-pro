package stringaddcalculator;

import java.util.Objects;

public class Number {
	private static final int ZERO = 0;
	private final int number;

	private Number(int number) {
		validateNotNegative(number);
		this.number = number;
	}

	public static Number from(String s) {
		return new Number(Integer.parseInt(s));
	}

	public static Number from(int n) {
		return new Number(n);
	}

	private void validateNotNegative(int number) {
		if (number < ZERO) {
			throw new RuntimeException("음수일 수 없습니다.");
		}
	}

	public Number sum(Number y) {
		return new Number(this.number + y.number);
	}

	public int getValue() {
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
