package lotto;

public class ScoreResultConverter {

    private ScoreResultConverter() {
        throw new IllegalStateException("유틸 클래스 입니다");
    }

    public static Score toResult(Score sourceScore) {
        if (sourceScore.equals(WinningResult.WIN_SECOND_BONUS.getMatchScore())) {
            return sourceScore;
        }
        return Score.of((int) sourceScore.getScore());
    }
}
