package lotto.enums;

import lotto.domain.MatchCount;
import lotto.domain.Money;

import java.util.Arrays;
import java.util.List;

public enum Rank {
    FIRST(6, 2000000000),
    SECOND(5, 1500000),
    THIRD(4, 50000),
    FOURTH(3, 5000),
    LOSE(2, 0);

    private MatchCount matchCount;
    private Money money;

    Rank(int matchCount, int money) {
        this.matchCount = MatchCount.from(matchCount);
        this.money = Money.from(money);
    }

    public static Rank rank(int matchCount) {
        MatchCount inputMatchCount = MatchCount.from(matchCount);
        return Arrays.stream(values())
                .filter(rank -> rank.matchCount.equals(inputMatchCount))
                .findFirst()
                .orElse(Rank.LOSE);
    }

    public static List<Rank> winningRanks() {
        return Arrays.asList(Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
    }

    public static boolean isWinning(Rank rank) {
        return rank != Rank.LOSE;
    }

    public int getMatchCount() {
        return matchCount.getMatchCount();
    }

    public int getMoney() {
        return money.getMoney();
    }
}
