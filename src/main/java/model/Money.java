package model;

import static model.EarningsRate.*;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {
	private BigDecimal value;

	private Money(int value) {
		this.value = BigDecimal.valueOf(value);
	}

	private Money(BigDecimal value) {
		this.value = value;
	}

	public static boolean validate(String moneyString) {
		return moneyString.matches(Regex.NUMBER)
			&& Integer.parseInt(moneyString) >= Lotto.COST;
	}

	public static Money of(Integer money) {
		return new Money(money);
	}

	public static Money of(Integer money, Count count) {
		return Money.of(money * count.getValue());
	}

	public static Money of(String moneyString) {
		try {
			return new Money(Integer.parseInt(moneyString));
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("숫자만 입력해야 합니다.");
		}
	}

	public PurchaseCount purchaseableCount(Money price) {
		if (price.equals(Money.of(0))) {
			throw new IllegalArgumentException("가격은 0원일 수 없습니다.");
		}

		return new PurchaseCount(this.value.intValue() / price.getValue().intValue());
	}

	public boolean isPurchaseable(Money price) {
		return this.value.compareTo(price.value) >= 0;
	}

	public BigDecimal getValue() {
		return value;
	}

	public Money use(Money money) {
		BigDecimal remain = value.subtract(money.value);
		if (remain.compareTo(BigDecimal.ZERO) < 0) {
			throw new IllegalArgumentException("가진 돈보다 더 많은 돈을 사용할 수 없습니다.");
		}

		return new Money(remain);
	}

	public Money multiply(Count count) {
		return new Money(value.multiply(count.toBigDecimal()));
	}

	public Money add(Money money) {
		return new Money(value.add(money.getValue()));
	}

	public BigDecimal divideForEarningsRate(Money money) {
		return value.divide(money.getValue(), EARNINGS_RATE_SCALE, EARNINGS_RATE_ROUNDING_MODE);
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Money money = (Money)o;
		return Objects.equals(value, money.value);
	}

	@Override
	public int hashCode() {
		return Objects.hash(value);
	}

	@Override
	public String toString() {
		return String.valueOf(value);
	}
}
