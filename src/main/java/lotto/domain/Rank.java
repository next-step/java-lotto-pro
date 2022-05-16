package lotto.domain;

import java.util.Arrays;

public enum Rank {
    FIRST(6, Money.from(2_000_000_000)),
    SECOND(5, Money.from(30_000_000)),
    THIRD(5, Money.from(1_500_000)),
    FOURTH(4, Money.from(50_000)),
    FIFTH(3, Money.from(5_000)),
    NONE(0, Money.from(0)),
    ;

    private final int matchCount;
    private final Money money;

    Rank(int matchCount, Money money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getMoney() {
        return money;
    }

    public static Rank matchResult(int matchCount, boolean isContainsBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.isEqualMatchCount(matchCount))
                .filter(rank -> !rank.equals(SECOND) || isContainsBonusNumber)
                .findAny()
                .orElse(Rank.NONE);
    }

    public boolean isEqualMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    public Money getWinningReward(int count) {
        return this.money.multiply(count);
    }
}
