package model;

import java.util.Objects;

public class LottoNumber {
	private final int number;

	public LottoNumber(int number) {
		this.number = number;
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
