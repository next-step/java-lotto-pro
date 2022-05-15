package lotto.enums;

import java.util.Arrays;

public enum Statistics {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(4, 1_500_000),
    FOURTH(3, 50_000),
    LOSE(0, 0);

    private final int matchingCount;
    private final int prize;

    Statistics(int matchingCount, int prize) {
        this.matchingCount = matchingCount;
        this.prize = prize;
    }

    public static Statistics getRank(int numberOfMatch) {
        return Arrays.stream(values())
                .filter(statistics -> statistics.matchingCount == numberOfMatch)
                .findAny()
                .orElse(LOSE);
    }
}
