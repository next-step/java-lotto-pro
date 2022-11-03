package lotto;

import java.util.Arrays;

public enum WinningResult {
    NOT_MATCH(Score.of(0), 0),
    MATCH_ONE(Score.of(1), 0),
    MATCH_TWO(Score.of(2), 0),
    WIN_FOURTH(Score.of(3), 5000),
    WIN_THIRD(Score.of(4), 50000),
    WIN_SECOND(Score.of(5), 1500000),
    WIN_SECOND_BONUS(Score.of(5.5), 30000000),
    WIN_FIRST(Score.of(6), 2000000000);

    private final Score matchScore;
    private final int winningPrice;

    WinningResult(Score matchScore, int winningResult) {
        this.matchScore = matchScore;
        this.winningPrice = winningResult;
    }

    public long resultPrice(long count) {
        return winningPrice * count;
    }

    public int getWinningPrice() {
        return winningPrice;
    }

    public Score getMatchScore() {
        return matchScore;
    }

    public static WinningResult getResultByMatchScore(Score matchScore) {
        return Arrays.stream(WinningResult.values())
                .filter(it -> it.matchScore.equals(ScoreResultConverter.toResult(matchScore)))
                .findFirst()
                .orElse(NOT_MATCH);
    }
}
