package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class WinningTest {
    @ParameterizedTest
    @MethodSource("provideOfTestParameter")
    void of(int count, boolean bonus, Winning expected) {
        assertThat(Winning.of(count, bonus)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideOfTestParameter() {
        return Stream.of(
                Arguments.of(6, true, Winning.FIRST_PRIZE),
                Arguments.of(6, false, Winning.FIRST_PRIZE),
                Arguments.of(5, true, Winning.SECOND_PRIZE),
                Arguments.of(5, false, Winning.THIRD_PRIZE),
                Arguments.of(4, true, Winning.FOURTH_PRIZE),
                Arguments.of(4, false, Winning.FOURTH_PRIZE),
                Arguments.of(3, true, Winning.FIFTH_PRIZE),
                Arguments.of(3, false, Winning.FIFTH_PRIZE),
                Arguments.of(2, true, Winning.NONE),
                Arguments.of(2, false, Winning.NONE),
                Arguments.of(0, true, Winning.NONE),
                Arguments.of(0, false, Winning.NONE)
        );
    }
}
