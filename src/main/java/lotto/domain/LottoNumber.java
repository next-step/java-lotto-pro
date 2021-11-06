package lotto.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LottoNumber {
	public static final String OUT_OF_RANGE_ERROR = "로또 번호의 범위는 1이상 45이하 입니다.";
	private static final int NUMBER_RANGE_MIN = 1;
	private static final int NUMBER_RANGE_MAX = 45;

	private static final Map<Integer, LottoNumber> numbers =new HashMap<>();

	static {
		for (int i = NUMBER_RANGE_MIN; i <= NUMBER_RANGE_MAX; i++) {
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
