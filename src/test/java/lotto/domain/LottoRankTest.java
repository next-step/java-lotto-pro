package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoRankTest {

    @DisplayName("일치하는 갯수와 따라서 순위를 알 수 있다.")
    @ParameterizedTest
    @MethodSource("rank_testcase")
    void rank(int matchCount, boolean matchBonus, LottoRank rank) {

        assertThat(LottoRank.valueOf(matchCount, matchBonus)).isEqualTo(rank);
    }

    @DisplayName("순위에 따라서 상금을 구할 수 있다.")
    @ParameterizedTest
    @MethodSource("rank_testcase")
    void winning_price(int matchCount, boolean matchBonus, LottoRank rank) {

        assertThat(LottoRank.valueOf(matchCount, matchBonus).getWinningPrice()).isEqualTo(rank.getWinningPrice());
    }

    private static Stream<Arguments> rank_testcase() {

        return Stream.of(
                //matchCount, matchBonus, LottoRank, winningPrice
                Arguments.of(6, false, LottoRank.FIRST),
                Arguments.of(5, true, LottoRank.SECOND),
                Arguments.of(5, false, LottoRank.THIRD),
                Arguments.of(4, false, LottoRank.FOURTH),
                Arguments.of(3, false, LottoRank.FIFTH),
                Arguments.of(2, false, LottoRank.FAIL),
                Arguments.of(1, false, LottoRank.FAIL),
                Arguments.of(0, false, LottoRank.FAIL)
        );
    }
}
