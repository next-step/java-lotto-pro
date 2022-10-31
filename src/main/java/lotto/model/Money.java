package lotto.model;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Objects;

public class Money {
	private final static long MIN_MONEY = 0L;

	private final long money;

	public Money(final long money) {
		if (money < MIN_MONEY) {
			throw new IllegalArgumentException("돈은 0보다 작을수 없다.");
		}
		this.money = money;
	}

	public long calculateQuantity() {
		return this.money / Lotto.LOTTO_PRICE.money;
	}

	public Money multiply(final int amount){
		return new Money(this.money * amount);
	}

	public float ratio(final Money income) {
		BigDecimal money = BigDecimal.valueOf(this.money);
		BigDecimal incomeMoney = BigDecimal.valueOf(income.money);
		return incomeMoney.divide(money, MathContext.DECIMAL32)
			.setScale(2, BigDecimal.ROUND_DOWN)
			.floatValue();
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		final Money money1 = (Money)o;
		return money == money1.money;
	}

	@Override
	public int hashCode() {
		return Objects.hash(money);
	}
}
