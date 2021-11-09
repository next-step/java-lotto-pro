package lotto.model.enums;

import static java.util.stream.Collectors.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public enum MatchCount {
    ZERO(0, 0),
    ONE(1, 0),
    TWO(2, 0),
    THREE(3, 5000),
    FOUR(4, 50000),
    FIVE(5, 1500000),
    SIX(6, 2000000000);

    private static final Map<Integer, MatchCount> VALUE_TO_ENUM =
        Arrays.stream(values()).collect(toMap(MatchCount::getCountOfMatch, e -> e));

    private final int countOfMatch;
    private final int winningMoney;

    MatchCount(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public static List<MatchCount> getMatchCountsWithWinningMoney() {
        return Arrays.asList(THREE, FOUR, FIVE, SIX);
    }

    public static MatchCount valueOf(int value) {
        return VALUE_TO_ENUM.get(value);
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }
}
