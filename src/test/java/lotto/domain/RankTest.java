package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @MethodSource("result")
    void 매치결과(int matchCount, Rank rank) {
        assertThat(Rank.matchResult(matchCount)).isEqualTo(rank);
    }

    private static Stream<Arguments> result() {
        return Stream.of(
                Arguments.of(6, Rank.FIRST),
                Arguments.of(5, Rank.SECOND),
                Arguments.of(4, Rank.THIRD),
                Arguments.of(3, Rank.FOURTH),
                Arguments.of(2, Rank.NONE),
                Arguments.of(1, Rank.NONE),
                Arguments.of(0, Rank.NONE)
        );
    }
}
