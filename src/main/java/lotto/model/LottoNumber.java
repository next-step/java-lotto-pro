package lotto.model;

import java.util.Objects;

import lotto.util.RandomUtil;

public class LottoNumber {

	public static final int MIN_LOTTO_NUMBER = 1;
	public static final int MAX_LOTTO_NUMBER = 45;

	private final int number;

	public LottoNumber() {
		this.number = RandomUtil.pickNumber(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER);
	}

	public LottoNumber(int number) {
		this.number = isNumberInLottoNumberRange(number);
	}

	private boolean validLottoNumber(int number) {
		return number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
	}

	private int isNumberInLottoNumberRange(int number) {
		if (validLottoNumber(number)) {
			throw new IllegalArgumentException();
		}
		return number;
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
