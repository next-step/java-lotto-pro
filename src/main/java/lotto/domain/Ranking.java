package lotto.domain;

import java.util.Arrays;

public enum Ranking {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NONE(0, 0);

    private int matchingCount;
    private int reward;

    Ranking(int matchingCount, int reward) {
        this.matchingCount = matchingCount;
        this.reward = reward;
    }

    public static Ranking findRank(int count) {
        return Arrays.stream(values())
                .filter(rank -> rank.matchingCount == count)
                .findFirst()
                .orElse(NONE);
    }
}
