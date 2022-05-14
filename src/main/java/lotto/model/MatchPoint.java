package lotto.model;

import java.util.Arrays;

public enum MatchPoint {
    FIRST(6, 2_000_000_000),
    //SECOND(5, 30_000_000),
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

    public static MatchPoint[] findValues() {
        return new MatchPoint[] {FIFTH, FOURTH, THIRD, FIRST};
    }

    public static MatchPoint findMatchPointByMatchPointCount(int count){
        return Arrays.stream(MatchPoint.findValues())
                .filter(matchPoint -> matchPoint.matchPointCount == count)
                .findFirst()
                .orElse(MISS);
    }

    public int getMatchPointCount() {
        return matchPointCount;
    }

    public int getCashPrize() {
        return cashPrize;
    }
}
