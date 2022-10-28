package lotto;

import java.math.BigDecimal;
import java.math.MathContext;

public class Money {
	private final long money;

	public Money(final long money) {
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
