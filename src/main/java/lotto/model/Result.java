package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
        List<Result> values = getValues(containsBonus);
        return values.stream()
            .filter(value -> value.getContainsCount() == count)
            .findFirst().orElse(Result.LOSE);
    }

    private static List<Result> getValues(boolean containsBonus) {
        List<Result> results = new ArrayList<>(Arrays.asList(values()));
        if (!containsBonus) {
            results.remove(SECOND);
        }
        return results;
    }

}
