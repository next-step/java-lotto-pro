package step2;

import java.util.Objects;

public class PositiveNumber {

	private final int positiveNumber;

	private PositiveNumber(String s) {
		this.positiveNumber = parse(s);
	}

	private int parse(String s) {
		int number;
		try {
			number = Integer.parseInt(s);
		} catch(NumberFormatException e) {
			throw new PositiveNumberFormatException();
		}
		validate(number);
		return number;
	}

	private void validate(int number) {
		if (number < 0) {
			throw new PositiveNumberFormatException();
		}
	}

	public static PositiveNumber from(String s) {
		return new PositiveNumber(s);
	}

	public int get() {
		return positiveNumber;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof PositiveNumber))
			return false;
		PositiveNumber that = (PositiveNumber)o;
		return positiveNumber == that.positiveNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(positiveNumber);
	}
}
