package model;

import java.util.Objects;

public final class LottoNumber implements Comparable<LottoNumber> {

	private final int value;

	private LottoNumber(int value) {
		this.value = value;
	}

	static LottoNumber from(int value) {
		return new LottoNumber(value);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		LottoNumber that = (LottoNumber)o;
		return value == that.value;
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public int compareTo(LottoNumber o) {
		return Integer.compare(value, o.value);
	}
}
