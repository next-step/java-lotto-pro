package step3.domain.enums;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GradeTest {

    @ParameterizedTest
    @CsvSource(value = {"5, true"})
    @DisplayName("로또번호 5개를 맞추고 보너스 번호까지 일치할 경우 2등이 되어야 한다")
    void return_two_if_bonus_match(int matchCount, boolean matchBonus) {
        // when
        Grade result = Grade.getGradeBy(matchCount, matchBonus);

        // then
        assertThat(result).isEqualTo(Grade.SECOND);
    }

    @ParameterizedTest
    @CsvSource(value = {"5, false"})
    @DisplayName("로또번호 5개를 맞추고 보너스 번호가 일치하지 않을 경우 3등이 되어야 한다")
    void return_third_if_bonus_not_match(int matchCount, boolean matchBonus) {
        // when
        Grade result = Grade.getGradeBy(matchCount, matchBonus);

        // then
        assertThat(result).isEqualTo(Grade.THIRD);
    }
}
