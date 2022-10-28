package lotto.domain.enums;

import lotto.domain.Money;
import lotto.domain.dto.StatisticDto;

import java.util.ArrayDeque;
import java.util.Deque;

public enum Rank {
    FIRST(6, new Money(2_000_000_000L)),
    SECOND(5, new Money(1_500_000L)),
    THIRD(4, new Money(50_000L)),
    FOURTH(3, new Money(5_000L));

    private final int matchCount;
    private final Money price;

    Rank(int matchCount, Money price) {
        this.matchCount = matchCount;
        this.price = price;
    }

    public static boolean isBiggerThanMinimum(int count) {
        return count >= FOURTH.matchCount;
    }

    public static Rank[] reverseValues() {
        Deque<Rank> deque = new ArrayDeque<>();
        for (Rank rank : Rank.values()) {
            deque.addFirst(rank);
        }

        return deque.toArray(new Rank[deque.size()]);
    }

    public static Money calculatePrice(StatisticDto dto) {
        Money totalMoney = new Money(0L);
        for (Rank rank : Rank.values()) {
            int count = dto.getCount(rank.matchCount);
            totalMoney.sum(rank.getPrice().multiply(count));
        }

        return totalMoney;
    }

    public Money getPrice() {
        return price;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
