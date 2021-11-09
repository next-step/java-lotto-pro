package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    WinningNumbers winningNumbers;
    LottoStatistics lottoStatistics;
    LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        winningNumbers = new WinningNumbers(new int[] {1, 2, 3, 4, 5, 6});
        lottoStatistics = new LottoStatistics(winningNumbers);

        lottoTickets = new LottoTickets(new int[][] {
                {1, 2, 3, 4, 5, 6},
                {1, 2, 3, 4, 5, 7},
                {1, 2, 3, 4, 5, 7},
                {1, 2, 3, 4, 7, 8},
                {1, 2, 3, 7, 8, 9},
                {1, 2, 7, 8, 9, 10},
                {1, 7, 8, 9, 10, 11},
                {7, 8, 9, 10, 11, 12}
        });
    }

    @Test
    void 로또_당첨_통계() {
        // given, when
        LottoRewardResult result = lottoStatistics.getLottoRewardResult(lottoTickets);

        // then
        Map<LottoReward, Integer> lottoRewardMap = result.getLottoRewardMap();
        assertThat(lottoRewardMap.size()).isEqualTo(4);
        assertThat(lottoRewardMap.get(LottoReward.FIRST_PLACE)).isEqualTo(1);
        assertThat(lottoRewardMap.get(LottoReward.SECOND_PLACE)).isEqualTo(2);
        assertThat(lottoRewardMap.get(LottoReward.FOURTH_PLACE)).isEqualTo(1);
        assertThat(lottoRewardMap.get(LottoReward.FIFTH_PLACE)).isEqualTo(1);
    }

    @Test
    void 수익률() {
        // given
        LottoRewardResult lottoRewardResult = lottoStatistics.getLottoRewardResult(lottoTickets);

        // when
        double rateOfProfit = lottoStatistics.getRateOfProfit(lottoTickets, lottoRewardResult);

        // then
        assertThat(rateOfProfit).isGreaterThan(0);
    }
}