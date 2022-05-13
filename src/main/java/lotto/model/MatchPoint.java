package lotto.model;

public enum MatchPoint {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    SIX(6, 2_000_000_000);

    private final int matchPointCount;
    private final int cashPrize;

    MatchPoint(int matchPointCount, int cashPrize) {
        this.matchPointCount = matchPointCount;
        this.cashPrize = cashPrize;
    }

    public long sumCashPrizeByMatchPoint(int count) {
        return (long) this.cashPrize * count;
    }

    public int getMatchPointCount() {
        return matchPointCount;
    }

    public int getCashPrize() {
        return cashPrize;
    }
}
