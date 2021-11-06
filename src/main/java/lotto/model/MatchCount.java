package lotto.model;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum MatchCount {
    ZERO(0), ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5), SIX(6);

    private static final Map<Integer, MatchCount> valueToEnum =
        Arrays.stream(values()).collect(Collectors.toMap(MatchCount::getValue, e -> e));

    private final int value;

    MatchCount(int value) {
        this.value = value;
    }

    public static MatchCount ofValue(int value) {
        return valueToEnum.get(value);
    }

    private int getValue() {
        return value;
    }
}
