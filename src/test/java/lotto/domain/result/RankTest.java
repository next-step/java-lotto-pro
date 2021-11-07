package lotto.domain.result;

import static org.assertj.core.api.Assertions.*;

import java.util.stream.*;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.*;
import org.junit.jupiter.params.provider.*;

import lotto.domain.number.*;

class RankTest {
    private static Stream<Arguments> provideRanksTest() {
        return Stream.of(
            Arguments.of(MatchedCount.from(6), false, Rank.FIRST),
            Arguments.of(MatchedCount.from(5), true, Rank.SECOND),
            Arguments.of(MatchedCount.from(5), false, Rank.THIRD),
            Arguments.of(MatchedCount.from(4), false, Rank.FOURTH),
            Arguments.of(MatchedCount.from(3), false, Rank.FIFTH),
            Arguments.of(MatchedCount.from(2), false, Rank.MISS),
            Arguments.of(MatchedCount.from(1), false, Rank.MISS),
            Arguments.of(MatchedCount.from(0), false, Rank.MISS)
        );
    }

    private static Stream<Arguments> providePrizeTest() {
        return Stream.of(
            Arguments.of(Rank.FIRST, 1, 2_000_000_000L),
            Arguments.of(Rank.FIRST, 2, 4_000_000_000L),
            Arguments.of(Rank.SECOND, 1, 30_000_000),
            Arguments.of(Rank.SECOND, 2, 60_000_000),
            Arguments.of(Rank.THIRD, 1, 1_500_000),
            Arguments.of(Rank.THIRD, 2, 3_000_000),
            Arguments.of(Rank.FOURTH, 1, 50_000),
            Arguments.of(Rank.FOURTH, 2, 100_000),
            Arguments.of(Rank.FIFTH, 1, 5_000),
            Arguments.of(Rank.FIFTH, 2, 10_000),
            Arguments.of(Rank.MISS, 1, 0),
            Arguments.of(Rank.MISS, 2, 0)
        );
    }

    @DisplayName("ranks메서드를 호출하면, 등수를 나타내는 enum객체를 전부 가지는 콜렉션 객체를 반환한다.")
    @Test
    void ranksTest() {
        assertThat(Rank.ranks()).containsExactly(Rank.FIRST, Rank.SECOND, Rank.THIRD, Rank.FOURTH, Rank.FIFTH);
    }

    @DisplayName("ranks메서드를 호출하면, 등수를 나타내는 enum객체를 전부 가지는 콜렉션 객체를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideRanksTest")
    void ranksTest(MatchedCount matchedCount, boolean containedBonusNumber, Rank expected) {
        assertThat(Rank.rankByMatchedCountAndBonusNumber(matchedCount, containedBonusNumber)).isEqualTo(expected);
    }

    @DisplayName("calculateTotalPrizeByGrade을 호출하면, 등수별 상금 총액을 반환한다.")
    @ParameterizedTest
    @MethodSource("providePrizeTest")
    void prizeTest(Rank rank, int ticketCount, long expected) {
        assertThat(Rank.calculateTotalPrizeByGrade(rank, ticketCount)).isEqualTo(expected);
    }
}
