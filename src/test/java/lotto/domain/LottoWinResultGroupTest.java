package lotto.domain;

import static generic.Money.valueOf;
import static java.util.Arrays.asList;
import static lotto.LottoTestUtils.resultGroup;
import static lotto.domain.LottoWinResult.FIRST;
import static lotto.domain.LottoWinResult.FOURTH;
import static lotto.domain.LottoWinResult.NO_WIN;
import static lotto.domain.LottoWinResult.SECOND;
import static lotto.domain.LottoWinResult.THIRD;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import generic.Money;
import java.util.stream.Stream;
import lotto.domain.LottoWinResult;
import lotto.domain.LottoWinResultGroup;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoWinResultGroupTest {

    @Test
    void 생성_테스트() {
        // when & then
        assertThat(new LottoWinResultGroup(asList(FIRST, NO_WIN, NO_WIN, NO_WIN)))
                .isEqualTo(new LottoWinResultGroup(asList(FIRST, NO_WIN, NO_WIN, NO_WIN)));
    }

    @ParameterizedTest
    @MethodSource("totalWinningPriceArgs")
    @DisplayName("당첨 결과에 따른 총 당첨 금액 조회")
    void totalWinningPrice(LottoWinResultGroup lottoWinResultGroup, Money price) {
        // when & then
        assertThat(lottoWinResultGroup.totalWinningPrice()).isEqualTo(price);
    }

    static Stream<Arguments> totalWinningPriceArgs() {
        return Stream.of(
                Arguments.of(resultGroup(FIRST, NO_WIN, NO_WIN, NO_WIN), Money.valueOf(2000000000)),
                Arguments.of(resultGroup(FOURTH, FOURTH, FOURTH), Money.valueOf(5000 + 5000 + 5000)),
                Arguments.of(resultGroup(FIRST, THIRD, SECOND, NO_WIN), Money.valueOf(2000000000 + 1500000 + 50000))
        );
    }

    @ParameterizedTest
    @MethodSource("countByWinResultArgs")
    @DisplayName("당첨 결과별 당첨 횟수 조회")
    void countByWinResult(LottoWinResultGroup lottoWinResultGroup, LottoWinResult winResult, long count) {
        // when & then
        assertThat(lottoWinResultGroup.countByWinResult(winResult)).isEqualTo(count);

    }

    static Stream<Arguments> countByWinResultArgs() {
        return Stream.of(
                Arguments.of(resultGroup(FIRST, NO_WIN, NO_WIN, NO_WIN), FIRST, 1),
                Arguments.of(resultGroup(FOURTH, FOURTH, FOURTH), FOURTH, 3),
                Arguments.of(resultGroup(FIRST, THIRD, SECOND, NO_WIN), FOURTH, 0)
        );
    }
}