package lotto.enums;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("로또 랭크 테스트")
class LottoRankTest {


    @DisplayName("숫자가 매칭되는 값에 따라 해당 순위를 알 수 있다.")
    @ParameterizedTest(name = "#{index} - {0}개가 매칭되면 {1}이다.")
    @MethodSource("match_rank")
    void number_matching_rank(int matchCount, LottoRank lottoRank, int price) {
        assertThat(LottoRank.findLottoRank(matchCount)).isEqualTo(lottoRank);
    }


    @DisplayName("숫자가 매칭되는 값에 따라 해당 순위의 상금을 알 수 있다.")
    @ParameterizedTest(name = "#{index} - {0}개가 매칭되면 상금은 {2}이다.")
    @MethodSource("match_rank")
    void winning_price(int matchCount, LottoRank lottoRank, int reward) {
        LottoRank rank = LottoRank.findLottoRank(matchCount);
        assertThat(rank.getReward()).isEqualTo(reward);
    }

    private static Stream<Arguments> match_rank() {
        return Stream.of(
                Arguments.of(6, LottoRank.FIRST, 2_000_000_000),
                Arguments.of(5, LottoRank.SECOND, 1_500_000),
                Arguments.of(4, LottoRank.THIRD, 50_000),
                Arguments.of(3, LottoRank.FOURTH, 5_000),
                Arguments.of(2, LottoRank.NONE, 0),
                Arguments.of(1, LottoRank.NONE, 0),
                Arguments.of(0, LottoRank.NONE, 0)
        );
    }


}