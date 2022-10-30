package step3.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNoException;

@DisplayName("로또_당첨_통계_클래스")
public class LottoWinningStatisticsTest {
    @DisplayName("로또_통계_정상")
    @Test
    void LottoWinningStatistics_pass_01() {

        List<LottoResult> lottoResults = new ArrayList<>();
        lottoResults.add(new LottoResult(new String[]{"1", "2", "3", "4", "5", "6"}));
        LottoResult winLottoResult = new LottoResult(new String[]{"1", "2", "3", "4", "5", "6"});
        assertThatNoException().isThrownBy(() -> new LottoWinningStatistics(lottoResults, winLottoResult));
    }

    @DisplayName("로또_통계_수익률_정상")
    @Test
    void LottoWinningStatistics_totalProfit_pass_01() {
        List<LottoResult> lottoResults = new ArrayList<>();
        lottoResults.add(new LottoResult(new String[]{"1", "2", "3", "4", "5", "6"}));
        LottoResult winLottoResult = new LottoResult(new String[]{"1", "2", "3", "4", "5", "6"});
        LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics(lottoResults, winLottoResult);
        assertThat(lottoWinningStatistics.getTotalProfitPercent(1000)).isEqualTo((double) LottoReward.SIX.getMoney() / 1000);
    }
}
