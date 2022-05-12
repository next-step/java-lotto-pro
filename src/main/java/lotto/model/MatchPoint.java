package lotto.model;

public enum MatchPoint {
    SIX(6, 2_000_000_000),
    FIVE(5, 1_500_000),
    FOUR(4, 50_000),
    THREE(3, 5_000);

    private int matchPointCount;
    private int cashPrize;

    MatchPoint(int matchPointCount, int cashPrize) {
        this.matchPointCount = matchPointCount;
        this.cashPrize = cashPrize;
    }
}
