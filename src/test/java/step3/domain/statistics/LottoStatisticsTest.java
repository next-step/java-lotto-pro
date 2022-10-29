package step3.domain.statistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.amount.Amount;
import step3.domain.lotto.Lottos;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @Test
    @DisplayName("총 당첨 금액을 리턴한다.")
    void getTotalWinningAmount() {
        Map<WinningLottoType, Integer> lottoResult = new HashMap<>();
        lottoResult.put(WinningLottoType.THIRD, 1);
        lottoResult.put(WinningLottoType.FOURTH, 2);
        lottoResult.put(WinningLottoType.NOTHING, 3);

        LottoStatistics lottoStatistics = new LottoStatistics(lottoResult);
        int totalWinningAmount = lottoStatistics.getTotalWinningAmount();
        assertThat(totalWinningAmount).isEqualTo(60000);
    }

    @Test
    @DisplayName("총 수익률을 리턴한다.")
    void getTotalProfit() {
        Map<WinningLottoType, Integer> lottoResult = new HashMap<>();
        lottoResult.put(WinningLottoType.FOURTH, 1);

        Lottos lottos = new Lottos(new Amount(14000));
        LottoStatistics lottoStatistics = new LottoStatistics(lottos, lottoResult);
        double totalProfit = lottoStatistics.getTotalProfit();
        assertThat(totalProfit).isEqualTo(0.35);
    }
}
