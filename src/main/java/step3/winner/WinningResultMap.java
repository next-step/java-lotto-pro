package step3.winner;

import java.util.Map;

public class WinningResultMap {

	private final Map<Rank, Integer> winnings;

	public WinningResultMap(Map<Rank, Integer> winnings) {
		this.winnings = winnings;
	}

	public int get(Rank findRank) {
		return winnings.entrySet().stream()
			.filter(winning -> winning.getKey().equals(findRank))
			.map(Map.Entry::getValue)
			.findFirst()
			.orElse(0);
	}
}
