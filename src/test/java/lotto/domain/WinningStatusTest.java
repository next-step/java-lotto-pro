package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatusTest {
    private static final WinningStatus winningStatus = WinningStatus.from(Arrays.asList(Rank.THIRD, Rank.NONE, Rank.NONE, Rank.NONE));

    @Test
    void create() {
        assertThat(winningStatus).isNotNull();
    }

    @ParameterizedTest
    @MethodSource("matchResult")
    void 특정_등수_당첨횟수_조회(Rank rank, long expected) {

        assertThat(winningStatus.numberOfWinning(rank)).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("winningReward")
    void 당첨금_조회(List<Rank> ranks, Money expected) {
        WinningStatus from = WinningStatus.from(ranks);
        assertThat(from.getWinningReward()).isEqualTo(expected);
    }

    @ParameterizedTest
    @MethodSource("winningYield")
    void 수익율_조회(List<Rank> ranks, double expected) {
        WinningStatus from = WinningStatus.from(ranks);
        Money lottoPrice = Money.from(1000);
        assertThat(from.getWinningYield(lottoPrice.multiply(ranks.size())))
                .isEqualTo(expected);
    }


    private static Stream<Arguments> matchResult() {
        return Stream.of(
                Arguments.of(Rank.FIRST, 0),
                Arguments.of(Rank.THIRD, 1),
                Arguments.of(Rank.NONE, 3)
        );
    }

    private static Stream<Arguments> winningReward() {
        return Stream.of(
                Arguments.of(Arrays.asList(Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE), Money.from(0)),
                Arguments.of(Arrays.asList(Rank.THIRD, Rank.NONE, Rank.NONE, Rank.NONE), Money.from(50_000)),
                Arguments.of(Arrays.asList(Rank.THIRD, Rank.THIRD, Rank.SECOND, Rank.NONE), Money.from(1_600_000))
        );
    }

    private static Stream<Arguments> winningYield() {
        return Stream.of(
                Arguments.of(Arrays.asList(Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE), 0.0),
                Arguments.of(Arrays.asList(Rank.THIRD, Rank.NONE, Rank.NONE, Rank.NONE), 12.5),
                Arguments.of(Arrays.asList(Rank.FOURTH, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE
                        , Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE, Rank.NONE), 0.5)
        );
    }
}
