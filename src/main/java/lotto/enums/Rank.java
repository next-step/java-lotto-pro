package lotto.enums;

import lotto.domain.MatchCount;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private MatchCount matchCount;
    private Money money;

    Rank(int matchCount, int money) {
        this.matchCount = MatchCount.from(matchCount);
        this.money = Money.from(money);
    }

    public static Rank rank(int matchCount, boolean matchBonusBall) {
        MatchCount inputMatchCount = MatchCount.from(matchCount);
        if (isEqualsMatchCount(SECOND, inputMatchCount)) {
            return rankByBonusBall(matchBonusBall);
        }
        return Arrays.stream(values())
                .filter(rank -> isEqualsMatchCount(rank, inputMatchCount))
                .findFirst()
                .orElse(MISS);
    }

    private static boolean isEqualsMatchCount(Rank rank, MatchCount matchCount) {
        return rank.matchCount.equals(matchCount);
    }

    private static Rank rankByBonusBall(boolean matchBonusBall) {
        if (matchBonusBall) {
            return SECOND;
        }
        return THIRD;
    }

    public static List<Rank> winningRanks() {
        return Arrays.asList(FIFTH, FOURTH, THIRD, SECOND, FIRST);
    }

    public static boolean isWinning(Rank rank) {
        return rank != MISS;
    }

    public int getMatchCount() {
        return matchCount.getMatchCount();
    }

    public int getMoney() {
        return money.getMoney();
    }
}
