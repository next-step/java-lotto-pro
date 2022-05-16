package lotto.domain;

public enum MatchResult {
    ZERO(0, Money.from(0)),
    ONE(1, Money.from(0)),
    TWO(2, Money.from(0)),
    THREE(3, Money.from(5000)),
    FOUR(4, Money.from(50000)),
    FIVE(5, Money.from(1500000)),
    SIX(6, Money.from(2000000000));


    private MatchResult(int matchCount, Money cashPrize) {
    }

    public static MatchResult from(int matchCount) {
        if (matchCount == 1) {
            return MatchResult.ONE;
        }
        if (matchCount == 2) {
            return MatchResult.TWO;
        }
        if (matchCount == 3) {
            return MatchResult.THREE;
        }
        if (matchCount == 4) {
            return MatchResult.FOUR;
        }
        if (matchCount == 5) {
            return MatchResult.FIVE;
        }
        if (matchCount == 6) {
            return MatchResult.SIX;
        }
        return MatchResult.ZERO;
    }
}
