package lotto;

import java.util.Arrays;
import java.util.function.Predicate;

public enum WinningResult {
    NOT_MATCH(score -> score.isBetween(0, 1), 0),
    MATCH_ONE(score -> score.isBetween(1, 2), 0),
    MATCH_TWO(score -> score.isBetween(2, 3), 0),
    WIN_FOURTH(score -> score.isBetween(3, 4), 5000),
    WIN_THIRD(score -> score.isBetween(4, 5), 50000),
    WIN_SECOND(score -> score.equals(Score.of(5)), 1500000),
    WIN_SECOND_BONUS(score -> score.isBetween(5.5, 6), 30000000),
    WIN_FIRST(score -> score.isBetween(6, 7), 2000000000);
    private Predicate<Score> matchScoreRange;
    private final int winningPrice;

    WinningResult(Predicate<Score> matchScoreRange, int winningResult) {
        this.matchScoreRange = matchScoreRange;
        this.winningPrice = winningResult;
    }

    public long resultPrice(long count) {
        return winningPrice * count;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public static WinningResult getResultByMatchScore(Score matchScore) {
        return Arrays.stream(WinningResult.values())
                .filter(it -> it.matchScoreRange.test(matchScore))
                .findFirst()
                .orElse(NOT_MATCH);
    }
}
