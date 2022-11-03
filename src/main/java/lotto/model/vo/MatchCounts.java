package lotto.model.vo;

import java.util.ArrayList;
import java.util.List;

public class MatchCounts {

    private static final int ADD_WIN_COUNT = 1;
    private static final int DO_NOT_ADD_WIN_COUNT = 0;
    private List<Integer> matchCounts;

    public void addMatchCount(int count) {
        if (matchCounts == null) {
            matchCounts = new ArrayList<>();
        }
        this.matchCounts.add(count);
    }

    public int countWin(WinCriterion winCriterion) {
        int winCount = 0;
        for (int matchCount : matchCounts) {
            winCount += addWinCount(winCriterion, matchCount);
        }
        return winCount;
    }

    private int addWinCount(WinCriterion winCriterion, int matchCount) {
        if (winCriterion.compareMatchCount(matchCount)) {
            return ADD_WIN_COUNT;
        }
        return DO_NOT_ADD_WIN_COUNT;
    }
}
