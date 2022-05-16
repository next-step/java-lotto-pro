package lotto.domain;

import static generic.Money.valueOf;
import static lotto.LottoTestUtils.resultGroup;
import static lotto.domain.LottoWinResult.FOURTH;
import static lotto.domain.LottoWinResult.NO_WIN;
import static lotto.domain.LottoWinResult.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import generic.Money;
import generic.Rate;
import java.util.stream.Stream;
import lotto.domain.LottoWinStatistics;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoWinStatisticsTest {

    @ParameterizedTest
    @MethodSource("getReturnRateArgs")
    @DisplayName("총 수익률 계산 확인")
    void getReturnRate(LottoWinStatistics lottoWinStatistics, Rate expected) {
        // when & then
        assertThat(lottoWinStatistics.getReturnRate()).isEqualTo(expected);
    }

    static Stream<Arguments> getReturnRateArgs() {
        return Stream.of(
                Arguments.of(new LottoWinStatistics(
                                Money.valueOf(5000), resultGroup(FOURTH, NO_WIN, NO_WIN, NO_WIN, NO_WIN)),
                        Rate.valueOf(1.0)),
                Arguments.of(new LottoWinStatistics(
                                Money.valueOf(5000), resultGroup(NO_WIN, NO_WIN, NO_WIN, NO_WIN, NO_WIN)),
                        Rate.valueOf(0.0)),
                Arguments.of(new LottoWinStatistics(
                                Money.valueOf(5000), resultGroup(THIRD, NO_WIN, NO_WIN, NO_WIN, NO_WIN)),
                        Rate.valueOf(10.0))
        );
    }

    @Test
    @DisplayName("당첨 결과별 당첨된 횟수 조회")
    void countByWinResult() {
        // given
        final LottoWinStatistics lottoWinStatistics = new LottoWinStatistics(Money.valueOf(5000),
                resultGroup(FOURTH, NO_WIN, NO_WIN, NO_WIN, NO_WIN));

        // when & then
        assertThat(lottoWinStatistics.countByWinResult(FOURTH)).isEqualTo(1);
        assertThat(lottoWinStatistics.countByWinResult(NO_WIN)).isEqualTo(4);
    }
}