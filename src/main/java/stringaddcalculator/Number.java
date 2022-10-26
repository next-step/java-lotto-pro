package stringaddcalculator;

import java.util.Objects;

public class Number {
	public static final int ZERO = 0;
	private int number;

	public Number(String s) {
		this.number = Integer.parseInt(s);
	}

	public Number(int n) {
		this.number = n;
	}

	public boolean isNegative() {
		return this.number < ZERO;
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
