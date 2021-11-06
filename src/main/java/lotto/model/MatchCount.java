package lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum MatchCount {
    ZERO(0, 0), ONE(1, 0), TWO(2, 0), THREE(3, 5000),
    FOUR(4, 50000), FIVE(5, 1500000), SIX(6, 2000000000);

    private static final Map<Integer, MatchCount> valueToEnum =
        Arrays.stream(values()).collect(Collectors.toMap(MatchCount::getValue, e -> e));

    private final int value;
    private final int prizeMoney;

    MatchCount(int value, int prizeMoney) {
        this.value = value;
        this.prizeMoney = prizeMoney;
    }

    public static MatchCount ofValue(int value) {
        return valueToEnum.get(value);
    }

    private int getValue() {
        return value;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }
}
