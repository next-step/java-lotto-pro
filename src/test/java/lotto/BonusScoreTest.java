package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static lotto.BonusScore.BONUS_SCORE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("보너스 점수 테스트")
class BonusScoreTest {

    @DisplayName("생성 성공")
    @Test
    void create_bonusScore_success() {
        assertThatNoException().isThrownBy(BonusScore::new);
    }

    @DisplayName("보너스 점수 가져오기 테스트")
    @Test
    void getScore_bonusScore_success() {
        //given:
        Score score = new BonusScore();
        assertThat(score.getScore()).isEqualTo(BONUS_SCORE);
    }
}
