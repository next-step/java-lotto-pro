package lotto.domain;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

public class LottoNumber {

	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;

	public static final LottoNumber MAX = LottoNumber.of(MAX_NUMBER);

	private final int number;

	private LottoNumber(int number) {
		this.number = number;
	}

	public static LottoNumber of(int number) {
		verifyNumberInRange(number);

		return CachedLottoNumber.fetch(number);
	}

	private static void verifyNumberInRange(int number) {
		if (isNumberInRange(number)) {
			throw new IllegalArgumentException("로또 번호는 1이상 45이하의 숫자여야 합니다.");
		}
	}

	private static boolean isNumberInRange(int number) {
		return MIN_NUMBER > number || MAX_NUMBER < number;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		LottoNumber that = (LottoNumber)o;
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

	private static class CachedLottoNumber {
		private static final Map<Integer, LottoNumber> CACHE = new ConcurrentHashMap<>(LottoNumber.MAX_NUMBER);

		private static LottoNumber fetch(int number) {
			return CACHE.computeIfAbsent(number, LottoNumber::new);
		}
	}
}
