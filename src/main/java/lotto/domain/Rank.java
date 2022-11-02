package lotto.domain;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public enum Rank {
    FIRST(6, new Money(2_000_000_000L)),
    SECOND(5, new Money(30_000_000L)),
    THIRD(5, new Money(1_500_000L)),
    FOURTH(4, new Money(50_000L)),
    FIFTH(3, new Money(5_000L)),
    MISS(0, new Money(0L));

    private final int matchCount;
    private final Money money;

    Rank(int matchCount, Money money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Rank[] reverseValues() {
        Deque<Rank> deque = new ArrayDeque<>();
        for (Rank rank : Rank.values()) {
            deque.addFirst(rank);
        }

        return deque.toArray(new Rank[deque.size()]);
    }

    public static Rank get(int matchCount, boolean isBonus) {
        if (matchCount == Rank.SECOND.getMatchCount() && isBonus) {
            return Rank.SECOND;
        }

        if (matchCount == Rank.THIRD.getMatchCount()) {
            return Rank.THIRD;
        }

        return Arrays.stream(Rank.values())
                .filter(s -> s.getMatchCount() == matchCount)
                .findFirst()
                .orElse(Rank.MISS);
    }

    public Money getMoney() {
        return money;
    }

    public Long getMoneyValue() {
        return money.value();
    }

    public int getMatchCount() {
        return matchCount;
    }
}
