package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    private static Stream<Arguments> rankingTest() {
        return Stream.of(
                Arguments.of(1, Rank.MISS),
                Arguments.of(2, Rank.MISS),
                Arguments.of(3, Rank.FIFTH),
                Arguments.of(4, Rank.FOURTH),
                Arguments.of(5, Rank.THIRD),
                Arguments.of(6, Rank.FIRST),
                Arguments.of(0, Rank.MISS)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("등수 체크 검증")
    public void rankingTest(int countOfMatch, Rank rank) {
        assertThat(Rank.valueOf(countOfMatch)).isEqualTo(rank);
    }
}