package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    FAIL(0, 0);

    private final int matchCount;
    private final int winningAmount;

    Rank(int matchCount, int winningAmount) {

        this.matchCount = matchCount;
        this.winningAmount = winningAmount;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getWinningAmount() {
        return winningAmount;
    }

    public boolean sameMatchCount(long count) {
        return this.getMatchCount() == count;
    }

    public String getWinningAmountString() {
        return String.format("%d원", this.getWinningAmount());
    }

    public static Rank findRank(long matchCount, boolean hasBonusNumber) {
        if (SECOND.sameMatchCount(matchCount) && hasBonusNumber) {
            return SECOND;
        }

        return Arrays.stream(Rank.values())
                .filter(rank -> rank.sameMatchCount(matchCount))
                .findFirst()
                .orElse(FAIL);
    }
}
