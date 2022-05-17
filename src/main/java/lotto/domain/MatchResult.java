package lotto.domain;

public enum MatchResult {
    ZERO(0, Money.from(0)),
    ONE(1, Money.from(0)),
    TWO(2, Money.from(0)),
    THREE(3, Money.from(5000)),
    FOUR(4, Money.from(50000)),
    FIVE(5, Money.from(1500000)),
    SIX(6, Money.from(2000000000));


    private final int matchCount;
    private final Money cashPrize;

    private MatchResult(int matchCount, Money cashPrize) {
        this.matchCount = matchCount;
        this.cashPrize = cashPrize;
    }

    public static MatchResult from(int matchCount) {
        for (MatchResult matchResult : MatchResult.values()) {
            if (matchResult.matchCount == matchCount) {
                return matchResult;
            }
        }
        throw new IllegalArgumentException("당첨 번호와 일치하는 로또 숫자의 개수는 0과 6 범위이어야 합니다");
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getCashPrize() {
        return cashPrize;
    }

}
