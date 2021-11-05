package com.example.lotto;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

public class LottoNumber {
	public static final int ONE = 1;
	public static final int FORTY_FIVE = 45;

	private static final Map<Integer, LottoNumber> candidateNumbers = new HashMap<>();

	static {
		for (int i = ONE; i <= FORTY_FIVE; i++) {
			candidateNumbers.put(i, new LottoNumber(i));
		}
	}

	private final int value;

	private LottoNumber(int number) {
		this.value = number;
	}

	static LottoNumber of(int number) {
		String exceptionMessage = String.format("로또 숫자는 1과 45 사이의 숫자이어야 합니다. 입력된 숫자는 %d입니다.", number);

		return Optional.ofNullable(candidateNumbers.get(number))
			.orElseThrow(() -> new IllegalArgumentException(exceptionMessage));
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		LottoNumber that = (LottoNumber)obj;
		return value == that.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
