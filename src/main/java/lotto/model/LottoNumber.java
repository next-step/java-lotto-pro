package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumber implements Comparable<LottoNumber> {
	private final static int LOTTO_MIN_NUMBER = 1;
	private final static int LOTTO_MAX_NUMBER = 45;

	private final int number;

	public LottoNumber(final int number) {
		validate(number);
		this.number = number;
	}

	@Override
	public int compareTo(final LottoNumber otherNumber) {
		return Integer.compare(this.number, otherNumber.number);
	}

	public static List<LottoNumber> of(final String... numbers) {
		return Arrays.stream(numbers)
			.mapToInt(Integer::parseInt)
			.mapToObj(LottoNumber::of)
			.collect(Collectors.toList());
	}

	public static List<LottoNumber> of(final int... numbers) {
		return Arrays.stream(numbers)
			.mapToObj(LottoNumber::of)
			.collect(Collectors.toList());
	}

	public static LottoNumber of(final String number) {
		return of(Integer.parseInt(number));
	}

	public static LottoNumber of(final int number) {
		validate(number);
		return LottoNumberCache.cache[number - 1];
	}

	private static void validate(final int number) {
		if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
			throw new IllegalArgumentException("로또의 숫자 범위는 1~45 이다.");
		}
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final LottoNumber that = (LottoNumber)o;
		return number == that.number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}

	private static class LottoNumberCache {
		static final LottoNumber[] cache = new LottoNumber[LOTTO_MAX_NUMBER];

		static {
			for (int number = LOTTO_MIN_NUMBER; number <= LOTTO_MAX_NUMBER; number++) {
				cache[number - 1] = new LottoNumber(number);
			}
		}
	}
}
