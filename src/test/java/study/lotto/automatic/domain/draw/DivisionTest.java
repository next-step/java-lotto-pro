package study.lotto.automatic.domain.draw;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DivisionTest {
    static Stream<Arguments> parameters() {
        return Stream.of(
                Arguments.arguments(6, Division.DIVISION_ONE),
                Arguments.arguments(5, Division.DIVISION_TWO),
                Arguments.arguments(4, Division.DIVISION_THREE),
                Arguments.arguments(3, Division.DIVISION_FOUR));
    }

    @ParameterizedTest(name = "{0}개 일치시 {1}")
    @MethodSource("parameters")
    @DisplayName("매치 카운트 수에 따른 등수를 반환한다.")
    void 매치_카운트_수에_따른_등수_반환(int matchCount, Division result) {
        assertThat(Division.valueOfMatchCount(matchCount)).isEqualTo(result);
    }
}
