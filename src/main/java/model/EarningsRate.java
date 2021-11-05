package model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Objects;

public class EarningsRate {
	private BigDecimal value;

	EarningsRate(BigDecimal value) {
		this.value = value.setScale(2, RoundingMode.FLOOR);
	}

	public static EarningsRate calculateOf(MatchResult matchResult, Money purchaseMoney) {
		BigDecimal totalPayout = MatchingNumberCount.THREE.getPrizeMoney().multiply(matchResult.getThreeMatchCount().toBigDecimal())
			.add(MatchingNumberCount.FOUR.getPrizeMoney().multiply(matchResult.getFourMatchCount().toBigDecimal()))
			.add(MatchingNumberCount.FIVE.getPrizeMoney().multiply(matchResult.getFiveMatchCount().toBigDecimal()))
			.add(MatchingNumberCount.SIX.getPrizeMoney().multiply(matchResult.getSixMatchCount().toBigDecimal()));

		return new EarningsRate(totalPayout.divide(purchaseMoney.getValue(), 2, RoundingMode.FLOOR));
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
