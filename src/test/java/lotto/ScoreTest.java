package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("점수 테스트")
class ScoreTest {

    @DisplayName("생성 성공")
    @Test
    void create_score_success() {
        assertThatNoException().isThrownBy(() -> Score.of(1));
    }

    @DisplayName("equals 메서드 테스트")
    @Test
    void equals_score_success() {
        //given:
        Score score = Score.of(1);
        //when, then:
        assertThat(score.equals(Score.of(1))).isTrue();
    }
}
