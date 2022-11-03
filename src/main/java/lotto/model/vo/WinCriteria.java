package lotto.model.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinCriteria {

    private List<WinCriterion> winCriteria;

    public void addWinCriterion(WinCriterion winCriterion) {
        if (winCriteria == null) {
            winCriteria = new ArrayList<>();
        }
        this.winCriteria.add(winCriterion);
    }

    public Map<WinCriterion, Integer> getWinCount(MatchCounts matchCounts) {
        Map<WinCriterion, Integer> winResult = new HashMap<>();
        for (WinCriterion winCriterion : winCriteria) {
            winResult.put(winCriterion, matchCounts.countWin(winCriterion));
        }
        return winResult;
    }
}
