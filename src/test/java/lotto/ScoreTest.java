package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.junit.jupiter.params.ParameterizedTest.DEFAULT_DISPLAY_NAME;

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

    @ParameterizedTest(name = "사이 값 검증" + DEFAULT_DISPLAY_NAME)
    @CsvSource(value = { "3:4:true", "3.1:4:false"}, delimiter = ':')
    void isBetween_score_success(double start, double end, boolean result) {
        //given:
        Score score = Score.of(3);
        //when, then:
        assertThat(score.isBetween(start,end)).isEqualTo(result);
    }
}
