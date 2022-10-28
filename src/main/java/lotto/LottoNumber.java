package lotto;

import java.util.Objects;

public class LottoNumber {

	public static final int MIN_NUMBER = 1;
	public static final int MAX_NUMBER = 45;
	private final int number;

	private LottoNumber(int number) {
		this.number = number;
	}

	public static LottoNumber of(int number) {
		verifyNumberInRange(number);
		return new LottoNumber(number);
	}

	private static void verifyNumberInRange(int number) {
		if (isNumberInRange(number)) {
			throw new IllegalArgumentException("로또 번호는 1이상 45이하의 숫자여야 합니다.");
		}
	}

	private static boolean isNumberInRange(int number) {
		return MIN_NUMBER > number || MAX_NUMBER < number;
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

	public boolean isEqualTo(int number) {
		return this.number == number;
	}

	@Override
	public int hashCode() {
		return Objects.hash(number);
	}

	@Override
	public String toString() {
		return String.valueOf(number);
	}

	public int compare(LottoNumber other) {
		return Integer.compare(number, other.number);
	}
}
