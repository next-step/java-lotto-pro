package lotto.domain;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {
	public static final int MIN_RANGE = 1;
	public static final int MAX_RANGE = 45;
	private final int lottoNumber;

	public LottoNumber(final int lottoNumber) {
		validateLottoNumberRange(lottoNumber);
		this.lottoNumber = lottoNumber;
	}

	private void validateLottoNumberRange(final int lottoNumber) {
		if (lottoNumber < MIN_RANGE) {
			throw new IllegalArgumentException("로또 번호는 1 ~ 45 범위여야 합니다.");
		}
		if (lottoNumber > MAX_RANGE) {
			throw new IllegalArgumentException("로또 번호는 1 ~ 45 범위여야 합니다.");
		}
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
	public String toString() {
		return Integer.toString(lottoNumber);
	}

	@Override
	public int compareTo(LottoNumber o) {
		return this.lottoNumber - o.lottoNumber;
	}
}
