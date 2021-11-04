package lotto;

import static lotto.common.Constants.*;

import java.util.Objects;

import lotto.common.Messages;

public class LottoNumber {
	private Integer number;

	public LottoNumber(Integer number) {
		validate(number);
		this.number = number;
	}

	private void validate(Integer number) {
		isPositiveNumber(number);
		isRangeValid(number);
	}

	private void isPositiveNumber(Integer number) {
		if (number < 0) {
			throw new IllegalArgumentException(Messages.POSITIVE_NUMBER_FORMAT_NOT_VALID.getValues());
		}
	}

	private void isRangeValid(Integer number) {
		if (number < START_NUMBER || number > END_NUMBER) {
			throw new IllegalArgumentException(Messages.INPUT_NUMBER_RANGE_NOT_VALID.getValues());
		}
	}

	public Integer getNumber() {
		return number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj instanceof LottoNumber) {
			LottoNumber other = (LottoNumber)obj;
			return Objects.equals(this.number, other.number);
		}
		return false;
	}

	@Override
	public String toString() {
		return number.toString();
	}
}
