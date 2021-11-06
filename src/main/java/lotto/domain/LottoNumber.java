package lotto.domain;

import java.util.Objects;

public class LottoNumber {
	public static final String OUT_OF_RANGE_ERROR = "로또 번호의 범위는 1이상 45이하 입니다.";
	private static final int NUMBER_RANGE_MIN = 1;
	private static final int NUMBER_RANGE_MAX = 45;

	private final int number;

	public LottoNumber(final int number) {
		validateNumberRange(number);

		this.number = number;
	}

	public int number() {
		return this.number;
	}

	private void validateNumberRange(int number) {
		if (number < NUMBER_RANGE_MIN || number > NUMBER_RANGE_MAX) {
			throw new IllegalArgumentException(OUT_OF_RANGE_ERROR);
		}
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

	@Override
	public String toString() {
		return "LottoNumber{" +
			"number=" + number +
			'}';
	}
}
