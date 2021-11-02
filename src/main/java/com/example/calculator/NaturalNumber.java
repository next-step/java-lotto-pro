package com.example.calculator;

import java.util.Objects;

public class NaturalNumber {
	private static final Integer ZERO = 0;

	private final int value;

	public NaturalNumber(int value) {
		throwOnLessOrEqualToZero(value);

		this.value = value;
	}

	public NaturalNumber(String value) {
		throwOnNotNumber(value);
		throwOnLessOrEqualToZero(Integer.parseInt(value));

		this.value = Integer.parseInt(value);
	}

	public static NaturalNumber add(NaturalNumber first, NaturalNumber second) {
		return new NaturalNumber(first.value + second.value);
	}

	private void throwOnLessOrEqualToZero(int value) {
		if (value <= ZERO) {
			throw new RuntimeException("값이 0보다 큰 정수여야 합니다.");
		}
	}

	private void throwOnNotNumber(String value) {
		try {
			Integer.parseInt(value);
		} catch (NumberFormatException e) {
			throw new RuntimeException("값은 숫자여야 합니다.");
		}
	}

	public int getValue() {
		return value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}

		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		NaturalNumber that = (NaturalNumber)o;
		return value == that.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}
}
