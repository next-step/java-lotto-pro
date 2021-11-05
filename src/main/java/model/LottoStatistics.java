package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoStatistics {
	private LottoStatistics() {
	}

	public static BigDecimal calculateForEarningsRate(MatchResult matchResult, Integer purchaseAmount) {
		BigDecimal totalPayout = MatchingNumberCount.THREE.getPrizeMoney().multiply(matchResult.getThreeMatchCount().toBigDecimal())
			.add(MatchingNumberCount.FOUR.getPrizeMoney().multiply(matchResult.getFourMatchCount().toBigDecimal()))
			.add(MatchingNumberCount.FIVE.getPrizeMoney().multiply(matchResult.getFiveMatchCount().toBigDecimal()))
			.add(MatchingNumberCount.SIX.getPrizeMoney().multiply(matchResult.getSixMatchCount().toBigDecimal()));

		return totalPayout.divide(BigDecimal.valueOf(purchaseAmount), 2, RoundingMode.FLOOR);
	}
}
