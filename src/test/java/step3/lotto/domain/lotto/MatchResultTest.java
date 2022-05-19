package step3.lotto.domain.lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author : choi-ys
 * @date : 2022/05/18 7:29 오후
 */
@DisplayName("Domain:MatchResult")
class MatchResultTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("당첨 번호와 일치하는 수에 대한 당첨 결과를 반환")
    public void matchResultTest(final int given, final boolean matchBonus, final MatchResult expected) {
        // When & Then
        assertThat(MatchResult.valueOf(given, matchBonus)).isEqualTo(expected);
    }

    private static Stream matchResultTest() {
        return Stream.of(
            Arguments.of(6, false, MatchResult.FIRST_PLACE),
            Arguments.of(5, true, MatchResult.SECOND_PLACE),
            Arguments.of(5, false, MatchResult.THIRD_PLACE),
            Arguments.of(3, false, MatchResult.FIFTH_PLACE),
            Arguments.of(2, false, MatchResult.NOTHING),
            Arguments.of(1, false, MatchResult.NOTHING),
            Arguments.of(0, false, MatchResult.NOTHING)
        );
    }
}
