package lotto.domain.win;


import java.util.Arrays;

public enum WinRanking {
    MISS(0, 0),
    FIFTH(3, 5000),
    FOURTH(4, 50000),
    THIRD(5, 1500000),
    SECOND(5, 30000000),
    FIRST(6, 2000000000),
    ;

    private final int matchCount;
    private final int winningMoney;

    WinRanking(int matchCount, int winningMoney) {
        this.matchCount = matchCount;
        this.winningMoney = winningMoney;
    }

    public static WinRanking of(int matchCount, boolean bonusNumber) {
        if (matchCount == SECOND.getMatchCount() && bonusNumber) {
            return SECOND;
        }
        return Arrays.stream(WinRanking.values())
                .filter(winRanking -> winRanking != SECOND)
                .filter(winRanking -> winRanking.getMatchCount() == matchCount)
                .findAny()
                .orElse(MISS);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
