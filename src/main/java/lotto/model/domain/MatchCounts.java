package lotto.model.domain;

import java.util.ArrayList;
import java.util.List;

public class MatchCounts {

    private static final int ADD_WIN_COUNT = 1;
    private static final int DO_NOT_ADD_WIN_COUNT = 0;
    private List<MatchCount> matchCounts;

    public void addMatchCount(MatchCount matchCount) {
        if (matchCounts == null) {
            matchCounts = new ArrayList<>();
        }
        this.matchCounts.add(matchCount);
    }

    public int countWin(WinCriterion winCriterion) {
        int winCount = 0;
        for (MatchCount matchCount : matchCounts) {
            winCount += addWinCount(winCriterion, matchCount);
        }
        return winCount;
    }

    private int addWinCount(WinCriterion winCriterion, MatchCount matchCount) {
        if (winCriterion.compareMatchCount(matchCount)) {
            return ADD_WIN_COUNT;
        }
        return DO_NOT_ADD_WIN_COUNT;
    }
}
