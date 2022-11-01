package lotto;

import java.util.Arrays;

public enum WinningResult {
    NOT_MATCH(0, 0),
    MATCH_ONE(1, 0),
    MATCH_TWO(2, 0),
    WIN_FOURTH(3, 5000),
    WIN_THIRD(4, 50000),
    WIN_SECOND(5, 1500000),
    WIN_SECOND_BONUS(5.5, 30000000),
    WIN_FIRST(6, 2000000000);

    private final double matchScore;
    private final int winningPrice;

    WinningResult(double matchScore, int winningResult) {
        this.matchScore = matchScore;
        this.winningPrice = winningResult;
    }

    public long resultPrice(long count) {
        return winningPrice * count;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public static WinningResult getResultByMatchScore(double matchScore) {
        return Arrays.stream(WinningResult.values())
                .filter(it -> it.matchScore == matchScore)
                .findFirst()
                .orElse(NOT_MATCH);
    }
}
