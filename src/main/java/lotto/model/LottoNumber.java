package lotto.model;

import static lotto.constants.LottoConstants.*;

import java.util.Objects;

public class LottoNumber implements Comparable<LottoNumber> {

	private final int number;

	public LottoNumber(int number) {
		if (!(number >= LOTTO_START_NUMBER && number <= LOTTO_END_NUMBER)) {
			throw new IllegalArgumentException("Lotto number must be between 1 and 45");
		}

		this.number = number;
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
	public int compareTo(LottoNumber o) {
		return Integer.compare(this.number, o.number);
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}
}
