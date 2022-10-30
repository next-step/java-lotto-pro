package study.step3.domain.lottostatistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import study.step3.domain.lotto.LottoRank;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @ParameterizedTest(name = "당첨 갯수: {0}, 당첨 순위: {1}, 수익률: {2}")
    @MethodSource("LottoRanksAndRateOfReturn")
    @DisplayName("당첨 순위에 해당되는 수익율을 계산한다")
    void calculate_rate_of_return_test(long rankCount, LottoRank lottoRank, double expectedRateOfReturn) {
        List<Long> matchCounts = LongStream.range(0, rankCount)
                .map(i -> lottoRank.matchCount())
                .boxed()
                .collect(Collectors.toList());
        LottoStatistics lottoStatistics = new LottoStatistics(14000L, matchCounts);
        double rateOfReturn = lottoStatistics.calculateRateOfReturn();
        assertThat(rateOfReturn).isEqualTo(expectedRateOfReturn);
    }

    private static Stream<Arguments> LottoRanksAndRateOfReturn() {
        return Stream.of(
                Arguments.of(1L, LottoRank.FIRST_PLACE, 142857.14),
                Arguments.of(1L, LottoRank.SECOND_PLACE, 107.14),
                Arguments.of(2L, LottoRank.THIRD_PLACE, 7.14),
                Arguments.of(3L, LottoRank.FOURTH_PLACE, 1.07),
                Arguments.of(1L, LottoRank.NONE, 0.0)
        );
    }
}
