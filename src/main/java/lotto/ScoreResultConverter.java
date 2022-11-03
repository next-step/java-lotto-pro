package lotto;

public class ScoreResultConverter {

    public static Score toResult(Score sourceScore) {
        if (sourceScore.equals(WinningResult.WIN_SECOND_BONUS.getMatchScore())) {
            return sourceScore;
        }
        return Score.of((int) sourceScore.getScore());
    }
}
