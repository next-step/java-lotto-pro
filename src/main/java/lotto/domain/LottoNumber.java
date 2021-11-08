package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import lotto.domain.exception.LottoNumberOutOfRangeException;

public class LottoNumber {

	private static final Map<Integer, LottoNumber> numbers =new HashMap<>();

	static {
		for (int i = Common.NUMBER_RANGE_MIN; i <= Common.NUMBER_RANGE_MAX; i++) {
			numbers.put(i, new LottoNumber(i));
		}
	}

	private final int number;

	private LottoNumber(final int number) {
		this.number = number;
	}

	public static LottoNumber from(final int number) {
		validateNumberRange(number);

		return numbers.get(number);
	}

	public int number() {
		return this.number;
	}

	private static void validateNumberRange(final int number) {
		if (number < Common.NUMBER_RANGE_MIN || number > Common.NUMBER_RANGE_MAX) {
			throw new LottoNumberOutOfRangeException();
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
