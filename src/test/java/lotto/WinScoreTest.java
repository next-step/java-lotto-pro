package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.WinScore.WIN_SCORE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("로또 당첨 점수 클래스 테스트")
class WinScoreTest {

    @DisplayName("생성 성공")
    @Test
    void create_score_success() {
        assertThatNoException().isThrownBy(WinScore::new);
    }

    @DisplayName("점수 값 가져오기 성공")
    @Test
    void getScore_score_success() {
        //given:
        Score score = new WinScore();
        assertThat(score.getScore()).isEqualTo(WIN_SCORE);
    }
}
