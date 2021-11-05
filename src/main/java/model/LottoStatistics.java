package model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class LottoStatistics {
 	public static final BigDecimal THREE_MATCH_PAYOUT = BigDecimal.valueOf(5_000);
	public static final BigDecimal FOUR_MATCH_PAYOUT = BigDecimal.valueOf(50_000);
	public static final BigDecimal FIVE_MATCH_PAYOUT = BigDecimal.valueOf(1_500_000);
	public static final BigDecimal SIX_MATCH_PAYOUT = BigDecimal.valueOf(2_000_000_000);

	private LottoStatistics() {}

	public static BigDecimal calculateForEarningsRate(MatchResult matchResult, Integer purchaseAmount) {
		BigDecimal totalPayout = THREE_MATCH_PAYOUT.multiply(BigDecimal.valueOf(matchResult.getThreeMatchCount()))
			.add(FOUR_MATCH_PAYOUT.multiply(BigDecimal.valueOf(matchResult.getFourMatchCount())))
			.add(FIVE_MATCH_PAYOUT.multiply(BigDecimal.valueOf(matchResult.getFiveMatchCount())))
			.add(SIX_MATCH_PAYOUT.multiply(BigDecimal.valueOf(matchResult.getSixMatchCount())));

		return totalPayout.divide(BigDecimal.valueOf(purchaseAmount), 2, RoundingMode.FLOOR);
	}
}
