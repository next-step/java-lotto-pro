package model.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public final class LottoNumber implements Comparable<LottoNumber> {

	private static final Map<Integer, LottoNumber> CACHE = new HashMap<>();

	private final int value;

	private LottoNumber(int value) {
		this.value = value;
	}

	public static LottoNumber from(int value) {
		return CACHE.computeIfAbsent(value, LottoNumber::new);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LottoNumber number = (LottoNumber)o;
		return value == number.value;
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
