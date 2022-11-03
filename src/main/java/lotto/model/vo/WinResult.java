package lotto.model.vo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    public void print() {
        List<WinCriterion> keySet = new ArrayList<>(winResult.keySet());
        Collections.sort(keySet);
        for (WinCriterion key : keySet) {
            key.print();
            System.out.println("- " + winResult.get(key) + "개");
        }
    }

}
