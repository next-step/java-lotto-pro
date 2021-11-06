package lotto.domain.result;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {
    private static Stream<Arguments> provideRanksTest() {
        return Stream.of(
            Arguments.of(6, Rank.FIRST),
            Arguments.of(5, Rank.SECOND),
            Arguments.of(4, Rank.THIRD),
            Arguments.of(3, Rank.FOURTH),
            Arguments.of(2, Rank.MISS),
            Arguments.of(1, Rank.MISS),
            Arguments.of(0, Rank.MISS)
        );
    }

    private static Stream<Arguments> providePrizeTest() {
        return Stream.of(
            Arguments.of(Rank.FIRST, 1, 2_000_000_000L),
            Arguments.of(Rank.FIRST, 2, 4_000_000_000L),
            Arguments.of(Rank.SECOND, 1, 1_500_000),
            Arguments.of(Rank.SECOND, 2, 3_000_000),
            Arguments.of(Rank.THIRD, 1, 50_000),
            Arguments.of(Rank.THIRD, 2, 100_000),
            Arguments.of(Rank.FOURTH, 1, 5_000),
            Arguments.of(Rank.FOURTH, 2, 10_000),
            Arguments.of(Rank.MISS, 1, 0),
            Arguments.of(Rank.MISS, 2, 0)
        );
    }

    @DisplayName("ranks메서드를 호출하면, 등수를 나타내는 enum객체를 전부 가지는 콜렉션 객체를 반환한다.")
    @Test
    void ranksTest() {
        assertThat(Rank.ranks()).containsExactly(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH);
    }

    @DisplayName("ranks메서드를 호출하면, 등수를 나타내는 enum객체를 전부 가지는 콜렉션 객체를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideRanksTest")
    void ranksTest(int countOfMatch, Rank expected) {
        assertThat(Rank.rankByCountOfMatch(countOfMatch)).isEqualTo(expected);
    }

    @DisplayName("calculateTotalPrizeByGrade을 호출하면, 등수별 상금 총액을 반환한다.")
    @ParameterizedTest
    @MethodSource("providePrizeTest")
    void prizeTest(Rank rank, int ticketCount, long expected) {
        assertThat(Rank.calculateTotalPrizeByGrade(rank, ticketCount)).isEqualTo(expected);
    }
}
