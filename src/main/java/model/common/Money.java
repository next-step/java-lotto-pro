package model.common;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import utility.Assert;

public final class Money {

	private static final Map<Integer, Money> CACHE = new HashMap<>();

	private static final int DEFAULT_DIVIDE_SCALE = 2;
	private static final RoundingMode DEFAULT_DIVIDE_ROUND = RoundingMode.FLOOR;

	private final int value;

	private Money(int value) {
		Assert.isTrue(positive(value), "'value' must be positive");
		this.value = value;
	}

	public static Money from(int value) {
		return CACHE.computeIfAbsent(value, Money::new);
	}

	public static Money from(String string) {
		return from(parseInt(string));
	}

	private static int parseInt(String string) {
		try {
			return Integer.parseInt(string);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(String.format("'%s' can not be changed to number", string), e);
		}
	}

	public boolean moreThan(Money money) {
		return value >= money.value;
	}

	public Money subtract(Money money) {
		if (value < money.value) {
			throw new IllegalStateException(String.format("not enough money(%d) to subtract %d", value, money.value));
		}
		return from(value - money.value);
	}

	public Money multiply(int value) {
		return from(this.value * value);
	}

	public BigDecimal ratio(Money money) {
		validateZero(money);
		return BigDecimal.valueOf(value)
			.divide(BigDecimal.valueOf(money.value), DEFAULT_DIVIDE_SCALE, DEFAULT_DIVIDE_ROUND);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		Money money = (Money)o;
		return value == money.value;
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return "Money{" +
			"value=" + value +
			'}';
	}

	public int divide(Money target) {
		validateZero(target);
		return value / target.value;
	}

	private void validateZero(Money money) {
		if (money.isZero()) {
			throw new IllegalArgumentException("can not divided by zero");
		}
	}

	private boolean isZero() {
		return value == 0;
	}

	private boolean positive(int value) {
		return value >= 0;
	}
}
