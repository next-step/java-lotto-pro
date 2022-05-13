package lotto;

import java.util.Objects;

public class Number {
	private static final int MINIMUM_VALUE = 1;
	private static final int MAXIMUM_VALUE = 45;
	private final int value;

	public Number(int value) {
		if (value < MINIMUM_VALUE || value > MAXIMUM_VALUE) {
			throw new IllegalArgumentException("숫자는 1~45만 가능합니다.");
		}
		this.value = value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
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
