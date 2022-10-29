package lotto.domain;

import java.util.Comparator;
import java.util.LinkedHashMap;
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

	public Map<Rank, Long> sortByMatchCount() {
		return rankResult.entrySet().stream()
			.filter(entry -> !entry.getKey().equals(Rank.LOSE))
			.sorted(Comparator.comparing(
				entry -> entry.getKey().getMatchCount(),
				Comparator.reverseOrder()))
			.collect(Collectors.toMap(
				Map.Entry::getKey,
				Map.Entry::getValue,
				(oldValue, newValue) -> oldValue,
				LinkedHashMap::new
			));
	}
}
