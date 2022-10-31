package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NO_MATCH(0, 0);

    private int matchCount;
    private long money;

    Rank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Rank of(int matchCount, boolean matchBonus) {
        if (matchCount < FIFTH.matchCount) {
            return Rank.NO_MATCH;
        }
        if (SECOND.isMatchCount(matchCount)) {
            return secondOrThirdRank(matchBonus);
        }
        return Arrays.stream(values())
                .filter(rank -> rank.isMatchCount(matchCount))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    private boolean isMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    private static Rank secondOrThirdRank(boolean matchBonus) {
        if (matchBonus) {
            return Rank.SECOND;
        }
        return Rank.THIRD;
    }

    public Money money() {
        return new Money(this.money);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public long getMoney() {
        return money;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)", matchCount, money);
    }

}
