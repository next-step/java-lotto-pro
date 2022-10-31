package enums;

import java.util.Arrays;

public enum Match {
    ZERO(0, 0),
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000),
    FIRST(6, 2_000_000_000);

    private final int matchCount;
    private final int amount;

    Match(int matchCount, int amount) {
        this.matchCount = matchCount;
        this.amount = amount;
    }

    public static Match findMatch(int matchCount) {
        return Arrays.stream(Match.values()).filter(prize -> prize.getCount() == matchCount)
                .findFirst()
                .orElse(ZERO);
    }

    public int getCount() {
        return matchCount;
    }

    public int getAmount() {
        return amount;
    }
}
