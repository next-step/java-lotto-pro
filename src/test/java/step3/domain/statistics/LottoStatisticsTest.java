package step3.domain.statistics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.domain.factory.Automatic;
import step3.domain.lotto.Lotto;
import step3.domain.lotto.Lottos;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class LottoStatisticsTest {

    @Test
    @DisplayName("총 당첨 금액을 리턴한다.")
    void getTotalWinningAmount() {
        Map<Rank, Integer> lottoResult = new HashMap<>();
        lottoResult.put(Rank.FOURTH, 1);
        lottoResult.put(Rank.FIFTH, 2);
        lottoResult.put(Rank.MISS, 3);

        LottoStatistics lottoStatistics = new LottoStatistics(lottoResult);
        int totalWinningAmount = lottoStatistics.getTotalWinningAmount();
        assertThat(totalWinningAmount).isEqualTo(60000);
    }

    @Test
    @DisplayName("총 수익률을 리턴한다.")
    void getTotalProfit() {
        Map<Rank, Integer> lottoResult = new HashMap<>();
        lottoResult.put(Rank.FIFTH, 1);

        Lottos lottos = new Lottos(Arrays.asList(new Lotto(new Automatic())));
        LottoStatistics lottoStatistics = new LottoStatistics(lottos, lottoResult);
        assertThat(lottoStatistics.getTotalProfit()).isEqualTo(5.0);
    }
}
