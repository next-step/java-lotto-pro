package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 45;

	private final int lottoNumber;

	public LottoNumber(int number) {
		validationLottoNumber(number);
		this.lottoNumber = number;
	}

	private void validationLottoNumber(int number) {
		if (isNotLottoNumber(number)) {
			throw new IllegalArgumentException();
		}
	}

	private boolean isNotLottoNumber(int number) {
		return MIN_NUMBER > number || MAX_NUMBER < number;
	}

	@Override
	public String toString() {
		return String.valueOf(lottoNumber);
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

	@Override
	public int compareTo(LottoNumber o) {
		if (this.lottoNumber > o.lottoNumber) {
			return 1;
		}
		if (this.lottoNumber < o.lottoNumber) {
			return -1;
		}
		return 0;
	}
}
