package lotto.domain;

import lotto.exception.InvalidMoneyException;

public class Money {

	private static final String DIVIDE_BY_ZERO_MESSAGE = "0으로 나눌 수 없습니다.";

	private final long value;

	private Money(long value) {
		validate(value);
		this.value = value;
	}

	public static Money from(int value) {
		return new Money(value);
	}

	public static Money from(long value) {
		return new Money(value);
	}

	private static void validate(long value) {
		if (value < 0) {
			throw new InvalidMoneyException("금액은 음수일 수 없습니다.");
		}
	}

	public long getValue() {
		return value;
	}

	public double divide(Money money) {
		if (money.value == 0) {
			throw new InvalidMoneyException(DIVIDE_BY_ZERO_MESSAGE);
		}
		return (double)this.value / money.value;
	}

	public boolean isLessThan(Money money) {
		return this.value < money.value;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		Money money = (Money)o;

		return value == money.value;
	}

	@Override
	public int hashCode() {
		return (int)(value ^ (value >>> 32));
	}

	public Money subtract(Money money) {
		return Money.from(this.value - money.value);
	}
}
