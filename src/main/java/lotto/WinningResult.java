package lotto;

import java.util.Arrays;
import java.util.function.Predicate;

public enum WinningResult {
    NOT_MATCH(score -> score.isBetween(0, 1), Money.of(0)),
    MATCH_ONE(score -> score.isBetween(1, 2), Money.of(0)),
    MATCH_TWO(score -> score.isBetween(2, 3), Money.of(0)),
    WIN_FOURTH(score -> score.isBetween(3, 4), Money.of(5000)),
    WIN_THIRD(score -> score.isBetween(4, 5), Money.of(50000)),
    WIN_SECOND(score -> score.equals(Score.of(5)), Money.of(1500000)),
    WIN_SECOND_BONUS(score -> score.isBetween(5.5, 6), Money.of(30000000)),
    WIN_FIRST(score -> score.isBetween(6, 7), Money.of(2000000000));
    private Predicate<Score> matchScoreRange;
    private final Money winningPrice;

    WinningResult(Predicate<Score> matchScoreRange, Money winningResult) {
        this.matchScoreRange = matchScoreRange;
        this.winningPrice = winningResult;
    }

    public long resultPrice(long count) {
        return winningPrice.getAmount() * count;
    }

    public long getWinningPrice() {
        return winningPrice.getAmount();
    }

    public static WinningResult getResultByMatchScore(Score matchScore) {
        return Arrays.stream(WinningResult.values())
                .filter(it -> it.matchScoreRange.test(matchScore))
                .findFirst()
                .orElse(NOT_MATCH);
    }
}
