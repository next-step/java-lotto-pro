package calculator;

import java.util.Objects;

public class Number {
	private final int value;

	private Number(int value) {
		if (value < 0) {
			throw new IllegalArgumentException("음수는 입력할 수 없습니다");
		}
		this.value = value;
	}

	public static Number from(int value) {
		return new Number(value);
	}

	public static Number from(String string) {
		try {
			return new Number(Integer.parseInt(string));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자만 입력할 수 있습니다");
		}
	}

	public static Number zero() {
		return new Number(0);
	}

	public Number add(Number other) {
		return new Number(value + other.value);
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Number number = (Number) o;
		return value == number.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
