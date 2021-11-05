package lotto;

import static common.Constants.*;

import java.util.Objects;

import exception.BusinessException;
import exception.ErrorMessages;

public class LottoNumber {
	private Integer lottoNumber;

	public LottoNumber(Integer lottoNumber) {
		validate(lottoNumber);
		this.lottoNumber = lottoNumber;
	}

	private void validate(Integer lottoNumber) {
		isPositiveNumber(lottoNumber);
		isRangeValid(lottoNumber);
	}

	private void isPositiveNumber(Integer number) {
		if (number < ZERO) {
			throw new BusinessException(ErrorMessages.POSITIVE_NUMBER_FORMAT_NOT_VALID);
		}
	}

	private void isRangeValid(Integer number) {
		if (number < START_NUMBER || number > END_NUMBER) {
			throw new BusinessException(ErrorMessages.INPUT_LOTTO_RANGE_NOT_VALID);
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return Objects.equals(lottoNumber, that.lottoNumber);
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumber);
	}

	@Override
	public String toString() {
		return lottoNumber.toString();
	}
}
