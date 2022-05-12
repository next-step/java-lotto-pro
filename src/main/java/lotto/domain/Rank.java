package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NONE(0, 0),
    ;

    private final int matchCount;
    private final int money;

    Rank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Rank matchResult(int matchCount) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isEqualMatchCount(matchCount))
                .findAny()
                .orElse(Rank.NONE);
    }

    public boolean isEqualMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }
}
