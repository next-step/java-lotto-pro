package model;

import static java.util.stream.Collectors.*;

import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.IntStream;

public class LottoNumber {
	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;
	public static final String OUT_OF_NUMBER_RANGE = "로또 번호의 범위를 벗어났습니다.";
	private static Map<Integer, LottoNumber> lottoNumbers;
	private int value;

	static {
		lottoNumbers = IntStream.rangeClosed(MIN_NUMBER, MAX_NUMBER)
			.boxed()
			.collect(toMap(Function.identity(), LottoNumber::new));
	}

	private LottoNumber(int number) {
		this.value = number;
	}

	public static LottoNumber of(String numberString) {
		return of(Integer.parseInt(numberString));
	}

	public static LottoNumber of(int number) {
		return Optional.ofNullable(lottoNumbers.get(number))
			.orElseThrow(() -> new IllegalArgumentException(OUT_OF_NUMBER_RANGE));
	}

	public static boolean isValidNumber(Integer number) {
		return number.compareTo(MIN_NUMBER) >= 0 && number.compareTo(MAX_NUMBER) <= 0;
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
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
