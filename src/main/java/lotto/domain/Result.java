package lotto.domain;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Result {

	private final Map<Rank, Long> rankResult;

	private Result(Map<Rank, Long> rankResult) {
		this.rankResult = rankResult;
	}

	public static Result of(Map<Rank, Long> rankResult) {
		return new Result(rankResult);
	}

	public static Result from(LottoTickets purchasedTickets, WinningLottoTicket winningTicket) {
		List<Integer> match = purchasedTickets.match(winningTicket);
		Ranks ranks = Ranks.of(match);
		return Result.of(ranks.groupBy());
	}

	public long totalPrize() {
		return rankResult.entrySet().stream()
			.mapToLong(entry -> entry.getKey().getPrize() * entry.getValue())
			.sum();
	}

	public String toString() {
		return rankResult.entrySet().stream()
			.map(entry -> entry.getKey().getMatchCount() + "개 일치 (" + entry.getKey().getPrize() + "원) - " + entry.getValue() + "개")
			.collect(Collectors.joining(System.lineSeparator()));
	}
}
