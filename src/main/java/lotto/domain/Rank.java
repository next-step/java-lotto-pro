package lotto.domain;

import java.util.Arrays;

public enum Rank {
    ONE(6, false, 2_000_000_000),
    TWO(5, true, 30_000_000),
    THREE(5, false, 1_500_000),
    FOUR(4, false, 50_000),
    FIVE(3, false, 5_000),
    MISS(-1, false, 0);

    private final int matchCount;
    private final boolean isMatcheBonus;
    private final int reward;

    Rank(int matchCount, boolean isMatcheBonus, int reward) {
        this.matchCount = matchCount;
        this.isMatcheBonus = isMatcheBonus;
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

    public static Rank valueOf(int matchCount, boolean isMatcheBonus) {
        Rank filteredRank = Arrays.stream(values())
            .filter(rank -> rank.matchCount == matchCount && !rank.isMatcheBonus)
            .findFirst().orElse(Rank.MISS);

        if (filteredRank.isThree() && isMatcheBonus) {
            return Rank.TWO;
        }
        return filteredRank;
    }

    private boolean isThree() {
        return this == THREE;
    }
}
