package lotto.model;

import java.util.Arrays;

public enum Result {

    WINNER(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    LOSE(0, 0);

    private final int containsCount;
    private final int prizeMoney;

    Result(int containsCount, int prizeMoney) {
        this.containsCount = containsCount;
        this.prizeMoney = prizeMoney;
    }

    public int getContainsCount() {
        return containsCount;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Result from(int count) {
        return Arrays.stream(values())
            .filter(value -> value.getContainsCount() == count)
            .findFirst().orElse(Result.LOSE);
    }
}
