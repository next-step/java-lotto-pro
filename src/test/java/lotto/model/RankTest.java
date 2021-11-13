package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class RankTest {
    @ParameterizedTest
    @MethodSource("provideOfTestParameter")
    void of(int count, boolean bonus, Rank expected) {
        assertThat(Rank.of(count, bonus)).isEqualTo(expected);
    }

    private static Stream<Arguments> provideOfTestParameter() {
        return Stream.of(
                Arguments.of(6, true, Rank.FIRST_PRIZE),
                Arguments.of(6, false, Rank.FIRST_PRIZE),
                Arguments.of(5, true, Rank.SECOND_PRIZE),
                Arguments.of(5, false, Rank.THIRD_PRIZE),
                Arguments.of(4, true, Rank.FOURTH_PRIZE),
                Arguments.of(4, false, Rank.FOURTH_PRIZE),
                Arguments.of(3, true, Rank.FIFTH_PRIZE),
                Arguments.of(3, false, Rank.FIFTH_PRIZE),
                Arguments.of(2, true, Rank.NONE),
                Arguments.of(2, false, Rank.NONE),
                Arguments.of(0, true, Rank.NONE),
                Arguments.of(0, false, Rank.NONE)
        );
    }
}
