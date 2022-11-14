package lotto.model.domain;

import java.util.HashMap;
import java.util.Map;

public enum WinCriterion {

    FIFTH(3, BonusBallMatch.DOES_NOT_MATTER, 5000),
    FORTH(4, BonusBallMatch.DOES_NOT_MATTER, 50000),
    THIRD(5, BonusBallMatch.NOT_MATCH, 1500000),
    SECOND(5, BonusBallMatch.MUST_MATCH, 30000000),
    FIRST(6, BonusBallMatch.DOES_NOT_MATTER, 2000000000);

    private int matchCount; // 일치하는 숫자 개수
    private BonusBallMatch bonusCount; // 보너스볼 일치 여부
    private long prize; // 상금

    WinCriterion(int matchCount, BonusBallMatch bonusCount, long prize) {
        this.matchCount = matchCount;
        this.bonusCount = bonusCount;
        this.prize = prize;
    }

    public static Map<WinCriterion, Integer> getWinCount(MatchCounts matchCounts) {
        Map<WinCriterion, Integer> winResult = new HashMap<>();
        for (WinCriterion winCriterion : WinCriterion.values()) {
            winResult.put(winCriterion, matchCounts.countWin(winCriterion));
        }
        return winResult;
    }

    public boolean compareMatchCount(MatchCount matchCount) {
        return matchCount.checkCount(this.matchCount, this.bonusCount);
    }

    public long calculatePrize(int count) {
        return this.prize * count;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getPrize() {
        return prize;
    }

    public boolean checkBonusMatch() {
        return this.bonusCount == BonusBallMatch.MUST_MATCH;
    }
}
