package money;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Objects;

public class Money {

	private static final DecimalFormat DECIMAL_FORMAT = new DecimalFormat("#,##0");

	public static final Money ZERO = new Money(BigDecimal.ZERO);
	private static final int FRACTION_SCALE = 2;

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
			throw new IllegalArgumentException("더 작은 금액을 뺄 수 없습니다.");
		}
		return Money.wons(subtractedAmount);
	}

	public boolean isLessThan(Money other) {
		return amount.compareTo(other.amount) < 0;
	}

	public Money add(Money other) {
		return Money.wons(amount.add(other.amount));
	}

	public BigDecimal divideBy(Money other) {
		return amount.divide(other.amount, FRACTION_SCALE, RoundingMode.DOWN);
	}

	public Money multiply(int count) {
		return Money.wons(amount.multiply(BigDecimal.valueOf(count)));
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

	@Override
	public String toString() {
		return DECIMAL_FORMAT.format(amount);
	}
}
