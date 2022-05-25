package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum MatchResult {
    FIRST(6, Money.from(2000000000), false),
    SECOND(5, Money.from(30000000), true),
    THIRD(5, Money.from(1500000), false),
    FOURTH(4, Money.from(50000), false),
    FIFTH(3, Money.from(5000), false),
    SIXTH(2, Money.from(0), false),
    SEVENTH(1, Money.from(0), false),
    EIGHTH(0, Money.from(0), false);

    private final int matchCount;
    private final Money cashPrize;
    private final boolean isBonus;


    MatchResult(int matchCount, Money cashPrize, boolean isBonus) {
        this.matchCount = matchCount;
        this.cashPrize = cashPrize;
        this.isBonus = isBonus;
    }

    public static MatchResult of(int matchCount, boolean isBonus) {

        return getMatchResult(matchCount, isBonus);
    }

    private static MatchResult getMatchResult(int matchCount, boolean isBonus) {
        return Arrays.stream(MatchResult.values())
                .filter(matchResult -> isSameMatchResult(matchResult, matchCount, isBonus))
                .findAny().orElseThrow(() -> new IllegalArgumentException("당첨번호 매칭 결과 케이스에 존재하지 않는 케이스입니다."));

    }

    private static boolean isSameMatchResult(MatchResult matchResult, int matchCount, boolean isBonus) {
        return matchResult.matchCount == matchCount && matchResult.isBonus == isBonus;
    }

    public static MatchResult[] winningMatchResults() {
        return Arrays.stream(MatchResult.values())
                .filter(MatchResult::isWinningMatchResult)
                .toArray(MatchResult[]::new);
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getCashPrize() {
        return cashPrize;
    }

    private static boolean isWinningMatchResult(MatchResult matchResult) {
        return !matchResult.getCashPrize().equals(Money.from(0));
    }

}
