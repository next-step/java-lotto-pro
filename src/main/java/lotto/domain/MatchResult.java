package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum MatchResult {

    FIRST(6, Money.from(2000000000)),
    SECOND(5, Money.from(30000000)),
    THIRD(5, Money.from(1500000)),
    FOURTH(4, Money.from(50000)),
    FIFTH(3, Money.from(5000)),
    SIXTH(2, Money.from(0)),
    SEVENTH(1, Money.from(0)),
    EIGHTH(0, Money.from(0));

    private static final MatchResult[] winningMatchResults = {
            MatchResult.FIRST,
            MatchResult.SECOND,
            MatchResult.THIRD,
            MatchResult.FOURTH,
            MatchResult.FIFTH
    };

    private final int matchCount;
    private final Money cashPrize;

    private MatchResult(int matchCount, Money cashPrize) {
        this.matchCount = matchCount;
        this.cashPrize = cashPrize;
    }

    public static MatchResult from(int matchCount) {
        Optional<MatchResult> result = Arrays.stream(MatchResult.values())
                .filter(matchResult -> matchResult.matchCount == matchCount)
                .findAny();
        if (result.isPresent()) {
            return result.get();
        }
        throw new IllegalArgumentException("당첨 번호와 일치하는 로또 숫자의 개수는 0과 6 범위이어야 합니다");
    }

    public static MatchResult of(int matchCount, boolean isBonus) {

        if (isSecond(matchCount, isBonus)) {
            return MatchResult.SECOND;
        }

        if (isThird(matchCount, isBonus)) {
            return MatchResult.THIRD;
        }

        return getMatchResult(matchCount);
    }

    private static MatchResult getMatchResult(int matchCount) {
        Optional<MatchResult> result = Arrays.stream(MatchResult.values())
                .filter(matchResult -> !matchResult.equals(MatchResult.SECOND))
                .filter(matchResult -> !matchResult.equals(MatchResult.THIRD))
                .filter(matchResult -> matchResult.matchCount == matchCount)
                .findAny();

        if (result.isPresent()) {
            return result.get();
        }
        throw new IllegalArgumentException("당첨 번호와 일치하는 로또 숫자의 개수는 0과 6 범위이어야 합니다");
    }

    private static boolean isSecond(int matchCount, boolean isBonus) {
        return MatchResult.SECOND.matchCount == matchCount && isBonus;
    }

    private static boolean isThird(int matchCount, boolean isBonus) {
        return MatchResult.THIRD.matchCount == matchCount && !isBonus;
    }

    public static MatchResult[] winningMatchResults() {
        return winningMatchResults;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public Money getCashPrize() {
        return cashPrize;
    }

}
