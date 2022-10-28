package lotto.domain;

import java.util.ArrayDeque;
import java.util.Deque;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    private final int matchCount;
    private final int price;

    Rank(int matchCount, int price) {
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

    public static Long calculatePrice(StatisticDto dto) {
        Long sum = 0L;
        for (Rank rank : Rank.values()) {
            int count = dto.getCount(rank.matchCount);
            sum += (long) rank.getPrice() * count;
        }

        return sum;
    }

    public int getPrice() {
        return price;
    }

    public int getMatchCount() {
        return matchCount;
    }
}
