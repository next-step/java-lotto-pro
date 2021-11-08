package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class EarningsRate {
	public static final int EARNINGS_RATE_SCALE = 2;
	public static final RoundingMode EARNINGS_RATE_ROUNDING_MODE = RoundingMode.FLOOR;
	private BigDecimal value;

	EarningsRate(BigDecimal value) {
		this.value = value.setScale(EARNINGS_RATE_SCALE, EARNINGS_RATE_ROUNDING_MODE);
	}

	public static EarningsRate calculateOf(MatchResult matchResult, Money purchaseMoney) {
		Money totalPayout = matchResult.calculateTotalPayout();

		return new EarningsRate(totalPayout.divideForEarningsRate(purchaseMoney));
	}

	public boolean isLessThanOne() {
		return BigDecimal.ONE.compareTo(this.value) > 0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		EarningsRate that = (EarningsRate)o;
		return Objects.equals(value, that.value);
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
