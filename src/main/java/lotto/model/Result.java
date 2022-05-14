package lotto.model;

import java.util.Arrays;

public enum Result {

    WINNER(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
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

    public static Result from(int count, boolean containsBonus) {
        return Arrays.stream(values())
            .filter(value -> value.getContainsCount() == count)
            .filter(value -> checkBonus(value, containsBonus))
            .findFirst().orElse(Result.LOSE);
    }

    private static boolean checkBonus(Result value, boolean containsBonus) {
        if (SECOND.equals(value)) {
            return containsBonus;
        }
        return true;
    }

}
