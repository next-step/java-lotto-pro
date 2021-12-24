package lotto.domain.wrapper;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public final class LottoNumber {
	public static final int START_NUMBER = 1;
	public static final int END_NUMBER = 45;
	private static final String MESSAGE_WRONG_NUMBER_RANGE = "로또 번호의 범위를 벗어났습니다.";
	private static final Map<Integer, LottoNumber> DEFAULT = new HashMap<>();
	private final int number;

	static {
		for (int i = START_NUMBER; i <= END_NUMBER; i++) {
			DEFAULT.put(i, new LottoNumber(i));
		}
	}

	private LottoNumber(int number) {
		if(number < START_NUMBER || number > END_NUMBER) {
			throw new IllegalArgumentException(MESSAGE_WRONG_NUMBER_RANGE);
		}
		this.number = number;
	}

	public static LottoNumber of(int number) {
		return Optional.ofNullable(DEFAULT.get(number))
			.orElseThrow(() -> new IllegalArgumentException(MESSAGE_WRONG_NUMBER_RANGE));
	}

	public static LottoNumber of(String number) {
		int num = Integer.valueOf(number);
		return of(num);
	}

	public int get() {
		return this.number;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof LottoNumber))
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
		return String.valueOf(number);
	}
}
