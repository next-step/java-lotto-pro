package lotto.domain;

import java.util.Map;
import java.util.Objects;

public class RankResult {

	private final Map<Rank, Long> rankResult;

	private RankResult(Map<Rank, Long> rankResult) {
		this.rankResult = rankResult;
	}

	public static RankResult from(Map<Rank, Long> rankResult) {
		return new RankResult(rankResult);
	}

	private long totalPrize(Map<Rank, Long> rankResult) {
		return rankResult.entrySet().stream()
			.mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
			.sum();
	}

	public Map<Rank, Long> getRankResult() {
		return rankResult;
	}

	public double profitRate(Money inputMoney) {
		long totalPrize = totalPrize(this.rankResult);
		double divide = Money.from(totalPrize).divide(inputMoney);
		return Math.round(divide * 100) / 100.0;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;

		RankResult that = (RankResult)o;

		return Objects.equals(rankResult, that.rankResult);
	}

	@Override
	public int hashCode() {
		return rankResult != null ? rankResult.hashCode() : 0;
	}
}
