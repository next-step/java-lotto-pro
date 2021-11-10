package model;

import java.util.Objects;

import exception.OutOfRangeException;

public class LottoNumber {
	private static final int BOUNDARY_MIN = 1;
	private static final int BOUNDARY_MAX = 45;
	public static final String MESSAGE_OUT_OF_RANGE =
		"NUMBER_IS_NOT_IN_RANGE_[" + BOUNDARY_MIN + "-" + BOUNDARY_MIN + "]";

	private final int number;

	public LottoNumber(int number) {
		validateNumberIsInRange(number);
		this.number = number;
	}

	private void validateNumberIsInRange(int number) {
		if (number < BOUNDARY_MIN || number > BOUNDARY_MAX) {
			throw new OutOfRangeException(MESSAGE_OUT_OF_RANGE);
		}
	}

	public int getComparatorOther(LottoNumber other) {
		return this.number < other.number ? -1 : 1;
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
		LottoNumber that = (LottoNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}
}
