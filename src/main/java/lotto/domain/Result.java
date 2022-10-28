package lotto.domain;

import java.util.Map;

public class Result {

	private final Map<Rank, Long> rankResult;

	private Result(Map<Rank, Long> rankResult) {
		this.rankResult = rankResult;
	}

	public static Result of(Map<Rank, Long> rankResult) {
		return new Result(rankResult);
	}

	public long totalPrize() {
		return rankResult.entrySet().stream()
			.mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
			.sum();
	}
}
