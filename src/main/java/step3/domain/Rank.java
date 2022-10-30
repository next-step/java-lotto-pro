package step3.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000L),
    THIRD(5, 1_500_000L),
    FOURTH(4, 50_000L),
    FIFTH(3, 5_000L),
    MISS(0, 0L);

    private final int matchCount;
    private final long prize;

    Rank(final int matchCount, final long prize) {
        this.matchCount = matchCount;
        this.prize = prize;
    }

    public static Rank of(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount == matchCount)
                .findFirst()
                .orElse(MISS);
    }

    public long prize() {
        return this.prize;
    }
}
