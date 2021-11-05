package lottogame;

import java.util.HashMap;
import java.util.Map;

public class LottoMatchResult {
	private Map<MatchRank, Integer> result;

	public LottoMatchResult() {
		this.result = new HashMap<>();
	}

	public void addCount(MatchRank matchRank){
		result.put(matchRank, result.getOrDefault(matchRank,0)+1);
	}

	public Map<MatchRank, Integer> getResult() {
		return result;
	}

	public String getResultToString(){
		return "";
	}
}
