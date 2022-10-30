package enums;

import java.util.Arrays;

public enum Match {
    ZERO(0, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

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
