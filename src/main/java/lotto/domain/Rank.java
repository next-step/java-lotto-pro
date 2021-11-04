package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    NO_MATCH(0, 0);

    private final int count;
    private final int price;

    Rank(int count, int price) {
        this.count = count;
        this.price = price;
    }

    public static Rank rank(int matchCount) {
        if (FOURTH.count > matchCount && NO_MATCH.count < matchCount) {
            return NO_MATCH;
        }

        return Arrays.stream(values())
                .filter(rank -> rank.isMatch(matchCount))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }

    public int getPrice() {
        return price;
    }

    private boolean isMatch(int matchCount) {
        return this.count == matchCount;
    }
}
