package lotto.domain;

import java.util.Map;

public class Result {

	private final Map<Rank, Long> rankResult;
	private final double profitRate;

	private Result(Map<Rank, Long> rankResult, double profitRate) {
		this.rankResult = rankResult;
		this.profitRate = profitRate;
	}

	public static Result of(Map<Rank, Long> rankResult, Money inputMoney) {
		return new Result(rankResult, profitRate(rankResult, inputMoney));
	}

	public static Result of(LottoTickets purchasedTickets, WinningLottoTicket winningTicket, Money inputMoney) {
		Ranks ranks = Ranks.from(purchasedTickets.match(winningTicket));
		Map<Rank, Long> resultMap = ranks.groupBy();
		double profitRate = profitRate(resultMap, inputMoney);
		return new Result(resultMap, profitRate);
	}

	private static double profitRate(Map<Rank, Long> resultMap, Money inputMoney) {
		long totalPrize = totalPrize(resultMap);
		return Money.from(totalPrize).divide(inputMoney);
	}

	private static long totalPrize(Map<Rank, Long> rankResult) {
		return rankResult.entrySet().stream()
			.mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
			.sum();
	}

	public Map<Rank, Long> getRankResult() {
		return rankResult;
	}

	public double getProfitRate() {
		return Math.round(profitRate * 100) / 100.0;
	}
}
