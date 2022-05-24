package lotto.domain;

import java.util.Collections;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 30000000),
    THIRD(5, 1500000),
    FOURTH(4, 50000),
    FIFTH(3, 5000),
    MISS(0, 0);

    private final int countOfMatch;
    private final int winningMoney;

    private static final Map<Integer, Rank> ranks = Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Rank::getCountOfMatch, Function.identity(),
                            (oldValue, newValue) -> newValue)));

    Rank(int countOfMatch, int winningMoney) {
        this.countOfMatch = countOfMatch;
        this.winningMoney = winningMoney;
    }

    public int getCountOfMatch() {
        return countOfMatch;
    }

    public int getWinningMoney() {
        return winningMoney;
    }

    public static Rank valueOf(int countOfMatch, boolean matchBonus) {
        if ((countOfMatch == SECOND.getCountOfMatch()) && matchBonus) {
            return SECOND;
        }

        return ranks.getOrDefault(countOfMatch, MISS);
    }
}
