package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchCount;
    private final int winningPrize;

    Rank(int mathCount, int winningPrize) {
        this.matchCount = mathCount;
        this.winningPrize = winningPrize;
    }

    public int getWinningPrize() {
        return winningPrize;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public static Rank valueOf(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(Rank.MISS);
    }
}
