package lotto.model.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class WinResult {

    private Map<WinCriterion, Integer> winResult;

    public WinResult(MatchCounts matchCounts) {
        this.winResult = WinCriterion.getWinCount(matchCounts);
    }

    public long calculateWinAmount() {
        long winAmount = 0;
        for (WinCriterion winCriterion : winResult.keySet()) {
            winAmount += winCriterion.calculatePrize(winResult.get(winCriterion));
        }
        return winAmount;
    }

    public List<WinCriterion> getWinCriterionFromWinResult() {
        List<WinCriterion> winCriteria = new ArrayList<>(winResult.keySet());
        Collections.sort(winCriteria);
        return winCriteria;
    }

    public int getCountByWinCriterion(WinCriterion winCriterion) {
        return winResult.get(winCriterion);
    }
}
