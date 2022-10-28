package lotto.domain;

import static lotto.domain.LottoRank.FAIL;
import static lotto.domain.LottoRank.FIRST;
import static lotto.domain.LottoRank.FOURTH;
import static lotto.domain.LottoRank.SECOND;
import static lotto.domain.LottoRank.THIRD;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.data.Offset;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LottoResultStatTest {

    @DisplayName("순위별로 당첨 수를 확인 할 수 있다.")
    @ParameterizedTest
    @MethodSource("rank_testcase")
    void result_by_rank(List<LottoRank> lottoRanks, int expect, LottoRank lottoRank) {

        LottoResultStat lottoResultStat = new LottoResultStat();

        lottoRanks.forEach(lottoResultStat::report);

        assertThat(lottoResultStat.resultByRank(lottoRank)).isEqualTo(expect);
    }

    @DisplayName("전체 수익률을 알 수 있다.")
    @ParameterizedTest
    @MethodSource("profit_testcase")
    void winning_profit(List<LottoRank> lottoRanks, double profit) {

        LottoResultStat lottoResultStat = new LottoResultStat();

        lottoRanks.forEach(lottoResultStat::report);

        assertThat(lottoResultStat.totalProfit()).isEqualTo(profit, Offset.offset(0.01));
    }

    private static Stream<Arguments> rank_testcase() {

        return Stream.of(
                Arguments.of(Arrays.asList(), 0, FAIL),
                Arguments.of(Arrays.asList(FIRST), 1, FIRST),
                Arguments.of(Arrays.asList(SECOND, SECOND), 2, SECOND),
                Arguments.of(Arrays.asList(THIRD, THIRD, THIRD), 3, THIRD),
                Arguments.of(Arrays.asList(FOURTH, FOURTH, FOURTH, FOURTH), 4, FOURTH)
        );
    }

    private static Stream<Arguments> profit_testcase() {

        return Stream.of(
                Arguments.of(Arrays.asList(FAIL, FAIL), 0),
                Arguments.of(Arrays.asList(FIRST), 2_000_000),
                Arguments.of(Arrays.asList(FAIL, FAIL, SECOND), 500),
                Arguments.of(Arrays.asList(FAIL, FAIL, FAIL, FAIL, FAIL, FAIL, FOURTH), 0.71)
        );
    }

}
