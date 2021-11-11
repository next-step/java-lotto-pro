package step3.winner;

import java.util.HashMap;
import java.util.Map;

public class MatchResult {

	private Map<Integer,Boolean> winningResult;

	public MatchResult() {
		winningResult = new HashMap<>();
	}

	public void put(Integer matchCount, boolean hasBonusBall) {
		winningResult.put(matchCount, hasBonusBall);
	}

	public boolean hasMatchCount(int matchCount) {
		return winningResult.containsKey(matchCount);
	}

	public boolean isBonusBalls(int matchCount) {
		return winningResult.get(matchCount);
	}

}
