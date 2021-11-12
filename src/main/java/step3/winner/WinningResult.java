package step3.winner;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class WinningResult {

	private final static int WINNING_COUNT = 1;
	private final static int ZERO = 0;
	private List<Rank> winnings;

	public WinningResult() {
		winnings = new ArrayList<>();
	}

	public void add(Integer matchCount, boolean isBonusBall) {
		winnings.add(Rank.valueOf(matchCount, isBonusBall));
	}

	public void add(Rank rank) {
		winnings.add(rank);
	}

	public boolean containsRank(Rank rank) {
		return winnings.contains(rank);
	}

	public WinningResultMap getStatistics() {
		return new WinningResultMap(winnings.stream()
			.collect(Collectors.toMap(
				(matchNumber -> matchNumber),
				matchNumber -> WINNING_COUNT,
				Integer::sum
			)));
	}

	public int getTotal() {
		return winnings.stream()
			.map(Rank::getAmount)
			.reduce(ZERO, Integer::sum);
	}
}
