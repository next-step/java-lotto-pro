package lotto.domain;

import java.util.Arrays;

public enum Rank {
    ONE(6, 2_000_000_000),
    TWO(5, 1_500_000),
    THREE(4, 50_000),
    FOUR(3, 5_000),
    MISS(-1, 0);

    private final int matchCount;
    private final int reward;

    Rank(int matchCount, int reward) {
        this.matchCount = matchCount;
        this.reward = reward;
    }

    public int matchCount() {
        return matchCount;
    }
    public int reward() {
        return reward;
    }
    public boolean isNotMiss() {
        return this != MISS;
    }

    public static Rank valueOf(int matchCount) {
        return Arrays.stream(values())
            .filter(rank -> rank.matchCount == matchCount)
            .findFirst()
            .orElse(Rank.MISS);
    }
}
