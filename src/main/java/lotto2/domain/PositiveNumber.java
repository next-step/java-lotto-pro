package lotto2.domain;

public class PositiveNumber {

	private final int number;

	private PositiveNumber(int number) {
		this.number = number;
	}

	public static PositiveNumber of(int inputNumber) {
		validateNumber(inputNumber);
		return new PositiveNumber(inputNumber);
	}

	private static void validateNumber(int number) {
		if (number < 0) {
			throw new IllegalArgumentException(
				ErrorMessage.ONLY_POSITIVE_NUMBER.value());
		}
	}
	
	public int toInt() {
		return this.number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		PositiveNumber that = (PositiveNumber)o;

		return number == that.number;
	}

	@Override
	public int hashCode() {
		return number;
	}
}
