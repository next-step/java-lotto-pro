package com.example.lotto;

import java.util.Objects;

public class LottoNumber {
	public static final int ONE = 1;
	public static final int FORTY_FIVE = 45;

	private final int value;

	public LottoNumber(int value) {
		throwOnInvalidValue(value);

		this.value = value;
	}

	private void throwOnInvalidValue(int value) {
		if (!isBetweenOneAndFortyFive(value)) {
			String message = String.format("로또 숫자는 1과 45 사이의 숫자이어야 합니다. 입력된 숫자는 %d입니다.", value);
			throw new IllegalArgumentException(message);
		}
	}

	private boolean isBetweenOneAndFortyFive(int value) {
		return LottoNumber.ONE <= value && value <= LottoNumber.FORTY_FIVE;
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
