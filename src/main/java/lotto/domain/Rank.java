package lotto.domain;

import java.util.Arrays;

public enum Rank {

    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NO_MATCH(0, 0);

    private int matchCount;
    private long money;

    Rank(int matchCount, int money) {
        this.matchCount = matchCount;
        this.money = money;
    }

    public static Rank of(int matchCount) {
        if (matchCount < FOURTH.matchCount) {
            return Rank.NO_MATCH;
        }
        return Arrays.stream(values())
                .filter(rank -> rank.isMatchCount(matchCount))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }

    public Money money() {
        return new Money(this.money);
    }

    private boolean isMatchCount(int matchCount) {
        return this.matchCount == matchCount;
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)", matchCount, money);
    }

}
