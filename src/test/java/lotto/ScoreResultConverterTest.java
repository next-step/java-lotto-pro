package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("당첨 점수 - 당첨 결과 변환기 테스트")
class ScoreResultConverterTest {

    @DisplayName("toResult 메서드 테스트 - 3등 당첨")
    @Test
    void toResult_score_success() {
        Score score = Score.of(3.5);
        assertThat(ScoreResultConverter.toResult(score)).isEqualTo(Score.of(3.0));
    }

    @DisplayName("toResult 메서드 테스트 - 2등 당첨")
    @Test
    void toResultBonusSecond_score_success() {
        Score score = Score.of(5.5);
        assertThat(ScoreResultConverter.toResult(score)).isEqualTo(score);
    }
}
