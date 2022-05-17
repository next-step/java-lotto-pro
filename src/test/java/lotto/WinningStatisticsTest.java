package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import lotto.domain.LottoRanking;
import lotto.domain.WinningStatistics;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {

    @Test
    public void addLottoRanking() {
        WinningStatistics winningStatistics = new WinningStatistics();
        assertThat(winningStatistics.addLottoRanking(LottoRanking.FIRST_PRIZE)).isEqualTo(1);
    }

    @Test
    public void calculateReturnRate() {
        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.addLottoRanking(LottoRanking.FOURTH_PRIZE);
        assertThat(winningStatistics.calculateRateOfReturn(14_000)).isEqualTo(0.35,
            withPrecision(0.01d));
    }
}
