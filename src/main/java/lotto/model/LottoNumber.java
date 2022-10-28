package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LottoNumber implements Comparable<LottoNumber> {
	private final static int LOTTO_MIN_NUMBER = 1;
	private final static int LOTTO_MAX_NUMBER = 45;

	private final int number;

	public LottoNumber(final String number){
		this(Integer.parseInt(number));
	}

	public LottoNumber(final int number) {
		validate(number);
		this.number = number;
	}

	private void validate(final int number) {
		if (number < LOTTO_MIN_NUMBER || number > LOTTO_MAX_NUMBER) {
			throw new IllegalArgumentException("로또의 숫자 범위는 1~45 이다.");
		}
	}

	@Override
	public int compareTo(final LottoNumber otherNumber) {
		return Integer.compare(this.number, otherNumber.number);
	}

	public static List<LottoNumber> of(final String ... numbers){
		return Arrays.stream(numbers)
			.map(LottoNumber::new)
			.collect(Collectors.toList());
	}

	public static List<LottoNumber> of(final int... numbers) {
		return Arrays.stream(numbers)
			.mapToObj(LottoNumber::new)
			.collect(Collectors.toList());
	}

	public static LottoNumber of(final int number) {
		return new LottoNumber(number);
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
}
