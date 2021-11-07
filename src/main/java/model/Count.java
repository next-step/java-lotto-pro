package model;

import java.math.BigDecimal;
import java.util.Objects;

public class Count {
	private int value;

	private Count(int value) {
		this.value = value;
	}

	public static Count zero() {
		return new Count(0);
	}

	public static Count one() {
		return new Count(1);
	}

	public static Count from(int value) {
		return new Count(value);
	}

	public static Count sum(Count count1, Count count2) {
		return new Count(count1.value + count2.value);
	}

	public BigDecimal toBigDecimal() {
		return BigDecimal.valueOf(value);
	}

	public boolean is(int value) {
		return this.value == value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Count count = (Count)o;
		return value == count.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
