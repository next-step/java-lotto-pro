package lotto;

import java.util.Objects;

public class LottoNumber {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;

	private final int lottoNumber;

	public LottoNumber(int number) {
		if (isNotLottoNumber(number)) {
			throw new IllegalArgumentException();
		}
		this.lottoNumber = number;
	}

	private boolean isNotLottoNumber(int number) {
		return MIN_NUMBER > number || MAX_NUMBER < number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return lottoNumber == that.lottoNumber;
	}

	@Override
	public int hashCode() {
		return Objects.hash(lottoNumber);
	}
}
