package lotto.domain;

import java.util.Arrays;

public enum LottoRank {
    MISS(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4,50_000),
    THIRD(5, 1_500_000),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final double winningMoney;

    LottoRank(int matchCount, double money) {
        this.matchCount = matchCount;
        this.winningMoney = money;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public double getWinningMoney() {
        return winningMoney;
    }

    public static LottoRank of(int matchCount) {
        return Arrays.stream(LottoRank.values())
                .filter(r -> r.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }
}
