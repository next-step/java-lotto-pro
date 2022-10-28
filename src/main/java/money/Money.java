package money;

import java.math.BigDecimal;
import java.util.Objects;

public class Money {

	public static final Money ZERO = new Money(BigDecimal.ZERO);

	private final BigDecimal amount;

	private Money(BigDecimal amount) {
		this.amount = amount;
	}

	public static Money wons(int amount) {
		return Money.wons(BigDecimal.valueOf(amount));
	}

	public static Money wons(BigDecimal amount) {
		verifyIsLessThanZero(amount);
		return new Money(amount);
	}

	private static void verifyIsLessThanZero(BigDecimal amount) {
		if (isNegative(amount)) {
			throw new IllegalArgumentException("금액은 0보다 작을 수 없습니다.");
		}
	}

	private static boolean isNegative(BigDecimal amount) {
		return amount.compareTo(BigDecimal.ZERO) < 0;
	}

	public Money subtract(Money other) {
		BigDecimal subtractedAmount = amount.subtract(other.amount);
		if (isNegative(subtractedAmount)) {
			return ZERO;
		}
		return Money.wons(subtractedAmount);
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
		return amount.equals(money.amount);
	}

	@Override
	public int hashCode() {
		return Objects.hash(amount);
	}

	public boolean isLessThan(Money other) {
		return amount.compareTo(other.amount) < 0;
	}
}
