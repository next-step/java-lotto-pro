package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6),
    SECOND(5),
    THIRD(4),
    FOURTH(3),
    NO_MATCH(0);

    private final int count;

    Rank(int count) {
        this.count = count;
    }

    public static Rank rank(int matchCount) {
        return Arrays.stream(values())
                .filter(rank -> rank.isMatch(matchCount))
                .findFirst()
                .orElse(NO_MATCH);
    }

    private boolean isMatch(int matchCount) {
        return this.count == matchCount;
    }
}
