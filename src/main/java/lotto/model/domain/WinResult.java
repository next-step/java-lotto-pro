package lotto.model.domain;

import java.util.Map;

public class WinResult {

    private Map<WinCriterion, Integer> winResult;

    public WinResult(WinCriteria winCriteria, MatchCounts matchCounts) {
        this.winResult = winCriteria.getWinCount(matchCounts);
    }

    public long calculateWinAmount() {
        long winAmount = 0;
        for (WinCriterion winCriterion : winResult.keySet()) {
            winAmount += winCriterion.calculatePrize(winResult.get(winCriterion));
        }
        return winAmount;
    }

    public Map<WinCriterion, Integer> getWinResult() {
        return winResult;
    }
}
