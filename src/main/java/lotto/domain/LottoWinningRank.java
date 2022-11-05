package lotto.domain;

import java.util.Arrays;

public enum LottoWinningRank {
    MISS(0, false, 0),
    FIFTH(3, false,5000),
    FOURTH(4, false,50000),
    THIRD(5, false,1500000),
    SECOND(5, true, 3000000),
    FIRST(6, false,2000000000);

    private int matchedCount;
    private boolean isBonusContain;
    private long winningMoney;

    LottoWinningRank(int matchedCount, boolean isBonusContain, long winningMoney) {
        this.matchedCount = matchedCount;
        this.isBonusContain = isBonusContain;
        this.winningMoney = winningMoney;
    }

    public static LottoWinningRank findRankByContainCountAndBonusContain(int containCount,
                                                                          boolean isBonusContain) {
        return Arrays.stream(values())
                .filter(value -> value.matchedCount == containCount && value.isBonusContain == isBonusContain)
                .findFirst()
                .orElse(MISS);
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public long getWinningMoney() {
        return winningMoney;
    }
}
