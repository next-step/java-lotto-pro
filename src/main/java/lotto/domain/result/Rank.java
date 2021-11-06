package lotto.domain.result;

import java.util.*;
import java.util.stream.*;

import lotto.domain.number.*;

public enum Rank {
    FIRST(6, Money.from(2_000_000_000)),
    SECOND(5, Money.from(30_000_000)),
    THIRD(5, Money.from(1_500_000)),
    FOURTH(4, Money.from(50_000)),
    FIFTH(3, Money.from(5_000)),
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

    public static Rank rankByMatchedCountAndBonusNumber(MatchedCount matchedCount, boolean containedBonusNumber) {
        Rank rank = Arrays.stream(Rank.values())
            .filter(e -> matchedCount.number() == e.matchCount())
            .findFirst()
            .orElse(MISS);

        if (matchedCount.isFive() && !containedBonusNumber) {
            return THIRD;
        }
        return rank;
    }

    public static long calculateTotalPrizeByGrade(Rank rank, int ticketCount) {
        return rank.money.multiply(ticketCount);
    }

    public static boolean isNotEqualToMiss(Rank rank) {
        return rank != MISS;
    }

    public int matchCount() {
        return matchCount;
    }

    public int money() {
        return money.number();
    }

}
