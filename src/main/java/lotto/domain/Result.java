package lotto.domain;

import java.util.Map;

public class Result {

	private final Map<Rank, Long> rankResult;
	private final double profitRate;


	private Result(Ranks ranks, Money inputMoney) {
		this.rankResult = ranks.groupBy();
		this.profitRate = profitRate(inputMoney);
	}

	public static Result of(Ranks ranks, Money money) {
		return new Result(ranks, money);
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

	public double getProfitRate() {
		return profitRate;
	}
}
