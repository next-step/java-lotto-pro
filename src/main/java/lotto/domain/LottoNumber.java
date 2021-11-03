package lotto.domain;

import java.util.Objects;

import lotto.utils.LottoNumberValidator;

public class LottoNumber {
	private final int number;

	private LottoNumber(int number) {
		this.number = number;
	}

	public static LottoNumber of(int number) {
		LottoNumberValidator.validateLottoNumber(number);
		return new LottoNumber(number);
	}

	public int getNumber() {
		return this.number;
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
