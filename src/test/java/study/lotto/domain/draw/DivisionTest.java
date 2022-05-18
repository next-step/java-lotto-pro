package study.lotto.domain.draw;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DivisionTest {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.arguments(6, false, Division.DIVISION_ONE),
                Arguments.arguments(5, true, Division.DIVISION_TWO),
                Arguments.arguments(5, false, Division.DIVISION_THREE),
                Arguments.arguments(4, true, Division.DIVISION_FOUR),
                Arguments.arguments(4, false, Division.DIVISION_FOUR),
                Arguments.arguments(3, true, Division.DIVISION_FIVE),
                Arguments.arguments(3, false, Division.DIVISION_FIVE));
    }

    @ParameterizedTest(name = "{0}개 일치시 {1}")
    @MethodSource("parameters")
    @DisplayName("매치 카운트 수와 보너스 번호 포함 여부에 따른 등수를 반환한다.")
    void 매치_카운트_수에_따른_등수_반환(int matchCount, boolean hasBonus, Division result) {
        assertThat(Division.valueOf(matchCount, hasBonus)).isEqualTo(result);
    }

    @Test
    @DisplayName("입력된 매치 카운트 수가 해당 등수의 매치 카운트와 일치하는지 여부를 반환한다.")
    void 매치_카운트_수가_같은지_확인() {
        assertThat(Division.DIVISION_ONE.hasSameMatchCount(6)).isTrue();
    }
}
