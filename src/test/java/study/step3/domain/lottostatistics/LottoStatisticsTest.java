package study.step3.domain.lottostatistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import study.step3.domain.lotto.LottoRank;
import study.step3.domain.utils.LottoStatisticsGenerator;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @ParameterizedTest(name = "당첨 갯수: {0}, 당첨 순위: {1}")
    @MethodSource("LottoRanksAndRateOfReturn")
    @DisplayName("주어진 당첨 순위의 갯수를 반환한다")
    void count_lotto_rank_test(long expectedRankCount, LottoRank lottoRank) {
        LottoStatistics lottoStatistics = LottoStatisticsGenerator.createLottoStatistics(expectedRankCount, lottoRank, 14000L);
        long rankCount = lottoStatistics.findLottoRankCount(lottoRank);
        assertThat(rankCount).isEqualTo(expectedRankCount);
    }

    @ParameterizedTest(name = "당첨 갯수: {0}, 당첨 순위: {1}, 수익률: {2}")
    @MethodSource("LottoRanksAndRateOfReturn")
    @DisplayName("당첨 순위에 해당되는 수익율을 계산한다")
    void calculate_rate_of_return_test(long rankCount, LottoRank lottoRank, double expectedRateOfReturn) {
        LottoStatistics lottoStatistics = LottoStatisticsGenerator.createLottoStatistics(rankCount, lottoRank, 14000L);
        double rateOfReturn = lottoStatistics.calculateRateOfReturn();
        assertThat(rateOfReturn).isEqualTo(expectedRateOfReturn);
    }

    private static Stream<Arguments> LottoRanksAndRateOfReturn() {
        return Stream.of(
                Arguments.of(1L, LottoRank.FIRST_PLACE, 142857.14),
                Arguments.of(1L, LottoRank.SECOND_PLACE, 107.14),
                Arguments.of(2L, LottoRank.THIRD_PLACE, 7.14),
                Arguments.of(3L, LottoRank.FOURTH_PLACE, 1.07)
        );
    }
}
