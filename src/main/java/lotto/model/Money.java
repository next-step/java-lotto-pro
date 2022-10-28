package lotto.model;

import java.math.BigDecimal;
import java.math.MathContext;

public class Money {
	private final static long MIN_MONEY = 0L;

	private final long money;

	public Money(final long money) {
		if (money < MIN_MONEY) {
			throw new IllegalArgumentException("돈은 0보다 작을수 없다.");
		}
		this.money = money;
	}

	public long calculateQuantity(final Money price) {
		return this.money / price.money;
	}

	public float ratio(final Money prize) {
		BigDecimal money = BigDecimal.valueOf(this.money);
		BigDecimal prizeMoney = BigDecimal.valueOf(prize.money);
		return prizeMoney.divide(money, MathContext.DECIMAL32)
			.setScale(2, BigDecimal.ROUND_DOWN)
			.floatValue();
	}
}
