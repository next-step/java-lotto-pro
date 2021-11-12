package lotto.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    WinningNumbers winningNumbers;
    Number bonusNumber;
    LottoStatistics lottoStatistics;
    LottoTickets lottoTickets;

    @BeforeEach
    void setUp() {
        winningNumbers = new WinningNumbers(new int[] {1, 2, 3, 4, 5, 6});
        bonusNumber = new Number(7);
        lottoStatistics = new LottoStatistics(winningNumbers, bonusNumber);

        lottoTickets = new LottoTickets(new int[][] {
                {1, 2, 3, 4, 5, 6}, // 1등
                {1, 2, 3, 4, 5, 7}, // 2등
                {1, 2, 3, 4, 5, 7}, // 2등
                {1, 2, 3, 4, 5, 8}, // 3등
                {1, 2, 3, 4, 7, 8}, // 4등
                {1, 2, 3, 7, 8, 9}, // 5등
                {1, 2, 7, 8, 9, 10}, // MISS
                {1, 7, 8, 9, 10, 11}, // MISS
                {7, 8, 9, 10, 11, 12} // MISS
        });
    }

    @Test
    void 로또_당첨_통계() {
        // given, when
        LottoRewardResult result = lottoStatistics.collectLottoRewardResult(lottoTickets);

        // then
        Map<LottoReward, Integer> lottoRewardMap = result.getLottoRewardMap();
        assertThat(lottoRewardMap.size()).isEqualTo(6);
        assertThat(lottoRewardMap.get(LottoReward.FIRST_PLACE)).isEqualTo(1);
        assertThat(lottoRewardMap.get(LottoReward.SECOND_PLACE)).isEqualTo(2);
        assertThat(lottoRewardMap.get(LottoReward.THIRD_PLACE)).isEqualTo(1);
        assertThat(lottoRewardMap.get(LottoReward.FOURTH_PLACE)).isEqualTo(1);
        assertThat(lottoRewardMap.get(LottoReward.FIFTH_PLACE)).isEqualTo(1);
    }

    @Test
    void 수익률() {
        // given
        LottoRewardResult lottoRewardResult = lottoStatistics.collectLottoRewardResult(lottoTickets);

        // when
        double rateOfProfit = lottoStatistics.calculateRateOfProfit(lottoTickets, lottoRewardResult);

        // then
        assertThat(rateOfProfit).isGreaterThan(0);
    }
}