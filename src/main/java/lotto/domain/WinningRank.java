package lotto.domain;

import java.util.Arrays;

public enum WinningRank {
    MISS_MATCH(0, 0, false),
    MATCH_THREE(3, 5_000, true),
    MATCH_FOUR(4, 50_000, true),
    MATCH_FIVE(5, 1_500_000, true),
    MATCH_SIX(6, 2_000_000_000, true);

    private final int matchCount;
    private final int winningMoney;
    private final boolean isDisplay;

    WinningRank(int matchCount, int winningMoney, boolean isDisplay) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
        this.isDisplay = isDisplay;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public boolean isDisplay() {
        return isDisplay;
    }

    public static WinningRank valueOf(int matchCount) {
        return Arrays.stream(WinningRank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(MISS_MATCH);
    }
}
