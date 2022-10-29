package lotto.domain;

import java.util.Arrays;

public enum Prize {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000),
    NOTHING(0, 0);

    private final int matchCount;
    private final int prizeMoney;

    Prize(int matchCount, int prizeMoney) {
        this.matchCount = matchCount;
        this.prizeMoney = prizeMoney;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getSumOfMoney(int count) {
        return prizeMoney * count;
    }

    public static Prize of(int matchCount) {
        return Arrays.stream(Prize.values())
            .filter(winPrize -> winPrize.matchCount == matchCount)
            .findFirst()
            .orElse(Prize.NOTHING);
    }

    @Override
    public String toString() {
        return String.format("%d개 일치 (%d원)", matchCount, prizeMoney);
    }
}
