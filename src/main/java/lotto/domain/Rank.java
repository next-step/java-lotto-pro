package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum Rank {
    MISS(0, new Money(0)),
    FIFTH(3, new Money(5_000)),
    FOURTH(4, new Money(50_000)),
    THIRD(5, new Money(1_500_000)),
    SECOND(5, new Money(30_000_000)),
    FIRST(6, new Money(2_000_000_000));

    private static final Map<Integer, Rank> countToRank =
        winningValues().stream()
            .filter(rank -> rank != SECOND)
            .collect(Collectors.toMap(rank -> rank.correctCount, Function.identity()));

    private final int correctCount;
    private final Money money;

    Rank(int correctCount, Money money) {
        this.correctCount = correctCount;
        this.money = money;
    }

    public static Rank valueOf(int correctCount, boolean containsBonus) {
        Rank rank = countToRank.getOrDefault(correctCount, MISS);
        if (rank == THIRD && containsBonus) {
            return SECOND;
        }

        return rank;
    }

    public static List<Rank> winningValues() {
        return Arrays.stream(values())
            .filter(rank -> rank != MISS)
            .collect(Collectors.toList());
    }

    public Money getMoney() {
        return money;
    }

    public int getCorrectCount() {
        return correctCount;
    }
}
