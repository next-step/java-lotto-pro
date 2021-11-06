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
                Arguments.of(0, false, Rank.MISS),
                Arguments.of(1, false, Rank.MISS),
                Arguments.of(2, false, Rank.MISS),
                Arguments.of(3, false, Rank.FIFTH),
                Arguments.of(4, false, Rank.FOURTH),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(6, false, Rank.FIRST)
        );
    }

    @ParameterizedTest
    @MethodSource
    @DisplayName("등수 체크 검증")
    public void rankingTest(int countOfMatch, boolean isBonusMatch, Rank rank) {
        assertThat(Rank.valueOf(countOfMatch, isBonusMatch)).isEqualTo(rank);
    }
}