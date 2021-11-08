package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FORTH(4, 50_000, false),
    FIFTH(3, 5_000, false),
    NO_MATCH(0, 0, false);

    private final int count;
    private final int price;
    private final boolean bonus;

    Rank(int count, int price, boolean bonus) {
        this.count = count;
        this.price = price;
        this.bonus = bonus;
    }

    public static Rank rank(int matchCount, boolean bonus) {
        if (FIFTH.count > matchCount && NO_MATCH.count < matchCount) {
            return NO_MATCH;
        }

        if (SECOND.count == matchCount && bonus) {
            return SECOND;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.isMatch(matchCount))
                .filter(rank -> !rank.bonus)
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getPrice() {
        return price;
    }

    private boolean isMatch(int matchCount) {
        return this.count == matchCount;
    }

    public int getCount() {
        return count;
    }
}
