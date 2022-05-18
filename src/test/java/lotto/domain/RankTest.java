package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RankTest {

    @ParameterizedTest
    @MethodSource("result")
    void 매치결과(int matchCount, boolean hasContainBonus, Rank expected) {
        assertThat(Rank.matchResult(matchCount, hasContainBonus)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("isEqualMatchCount")
    void 매치결과_비교(int matchCount, Rank rank, boolean expected) {
        assertThat(rank.isEqualMatchCount(matchCount)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("getWinningReward")
    void 당첨상금_계산(int matchCount, Rank rank, Money expected) {
        assertThat(rank.getWinningReward(matchCount)).isEqualTo(expected);
    }

    private static Stream<Arguments> result() {
        return Stream.of(
                Arguments.of(6, false, Rank.FIRST),
                Arguments.of(5, true, Rank.SECOND),
                Arguments.of(5, false, Rank.THIRD),
                Arguments.of(3, true, Rank.FIFTH),
                Arguments.of(2, false, Rank.NONE)
        );
    }

    private static Stream<Arguments> isEqualMatchCount() {
        return Stream.of(
                Arguments.of(6, Rank.FIRST, true),
                Arguments.of(2, Rank.SECOND, false),
                Arguments.of(0, Rank.NONE, true)
        );
    }

    private static Stream<Arguments> getWinningReward() {
        return Stream.of(
                Arguments.of(1, Rank.FIRST, Money.from(2_000_000_000)),
                Arguments.of(2, Rank.SECOND, Money.from(60_000_000)),
                Arguments.of(1, Rank.THIRD, Money.from(1_500_000))
        );
    }
}

