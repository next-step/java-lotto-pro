package lotto.domain;

import java.util.Arrays;
import java.util.Optional;

public enum MatchResult {
    FIRST(6, Money.from(2000000000)),
    SECOND(5, Money.from(30000000), true),
    THIRD(5, Money.from(1500000)),
    FOURTH(4, Money.from(50000)),
    FIFTH(3, Money.from(5000)),
    SIXTH(2, Money.from(0)),
    SEVENTH(1, Money.from(0)),
    EIGHTH(0, Money.from(0)),

    FIRST_WITH_BONUS(6, Money.from(2000000000), true),
    FOURTH_WITH_BONUS(4, Money.from(50000), true),
    FIFTH_WITH_BONUS(3, Money.from(5000), true),
    SIXTH_WITH_BONUS(2, Money.from(0), true),
    SEVENTH_WITH_BONUS(1, Money.from(0), true),
    EIGHTH_WITH_BONUS(0, Money.from(0), true);

    private final int matchCount;
    private final Money cashPrize;
    private final boolean isBonus;

    private MatchResult(int matchCount, Money cashPrize) {
        this.matchCount = matchCount;
        this.cashPrize = cashPrize;
        this.isBonus = false;
    }

    private MatchResult(int matchCount, Money cashPrize, boolean isBonus) {
        this.matchCount = matchCount;
        this.cashPrize = cashPrize;
        this.isBonus = isBonus;
    }

    public static MatchResult of(int matchCount, boolean isBonus) {

        return getMatchResult(matchCount, isBonus);
    }

    private static MatchResult getMatchResult(int matchCount, boolean isBonus) {
        Optional<MatchResult> result = Arrays.stream(MatchResult.values())
                .filter(matchResult -> isSameMatchResult(matchResult, matchCount, isBonus))
                .findAny();

        if (result.isPresent()) {
            return result.get();
        }
        throw new IllegalArgumentException("당첨 번호와 일치하는 로또 숫자의 개수는 0과 6 범위이어야 합니다");
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
