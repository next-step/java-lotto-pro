package lotto.domain.result;

import lotto.domain.number.Money;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum Rank {
    FIRST(6, Money.from(2_000_000_000)),
    SECOND(5, Money.from(1_500_000)),
    THIRD(4, Money.from(50_000)),
    FOURTH(3, Money.from(5_000)),
    MISS(0, Money.from(0));

    private final int matchCount;
    private final Money money;

    Rank(int matchCount, Money money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static List<Rank> ranks() {
        return Arrays.stream(Rank.values())
            .filter(Rank::isNotEqualToMiss)
            .collect(Collectors.toList());
    }

    public static Rank rankByCountOfMatch(int countOfMatch) {
        return Arrays.stream(Rank.values())
            .filter(rank -> countOfMatch == rank.matchCount())
            .findFirst()
            .orElse(MISS);
    }

    public static long calculateTotalPrizeByGrade(Rank rank, int ticketCount) {
        return rank.money.multiply(ticketCount);
    }

    private static boolean isNotEqualToMiss(Rank rank) {
        return rank != MISS;
    }

    public int matchCount() {
        return matchCount;
    }

    public int money() {
        return money.number();
    }

}
