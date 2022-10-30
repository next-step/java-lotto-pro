package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000),
    NONE(0, 0);

    private final int matchCount;
    private final int prize;

    Rank(int matchCount, int prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank valueOf(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(NONE);
    }

    public static Rank valueOf(int matchCount, boolean hasBonusBall) {
        if(matchCount == SECOND.getMatchCount() && hasBonusBall) {
            return SECOND;
        }
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.matchCount == matchCount)
                .findAny()
                .orElse(NONE);
    }

    public int getMatchCount() {
        return this.matchCount;
    }

    public int getPrize() {
        return this.prize;
    }
}
