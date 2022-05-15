package lotto.model;

import java.util.Arrays;

public enum MatchPoint {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    MISS(0, 0);

    private final int matchPointCount;
    private final int cashPrize;

    MatchPoint(int matchPointCount, int cashPrize) {
        this.matchPointCount = matchPointCount;
        this.cashPrize = cashPrize;
    }

    public long sumCashPrizeByMatchPoint(int count) {
        return (long) this.cashPrize * count;
    }

    public static MatchPoint findMatchPointByMatchPointCount(int count, boolean matchBonus){
        MatchPoint resultMatchPoint = Arrays.stream(MatchPoint.values())
                .filter(matchPoint -> matchPoint.matchPointCount == count)
                .findFirst()
                .orElse(MISS);

        if(resultMatchPoint.getMatchPointCount() == 5 && matchBonus){
            return MatchPoint.SECOND;
        }

        return resultMatchPoint;
    }

    public int getMatchPointCount() {
        return matchPointCount;
    }

    public int getCashPrize() {
        return cashPrize;
    }
}
