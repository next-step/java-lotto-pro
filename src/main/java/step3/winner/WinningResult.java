package step3.winner;

import java.util.ArrayList;
import java.util.List;

public class WinningResult {

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
}
