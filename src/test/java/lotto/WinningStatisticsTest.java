package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;

import lotto.domain.LottoRanking;
import lotto.domain.WinningStatistics;
import org.junit.jupiter.api.Test;

public class WinningStatisticsTest {

    @Test
    public void addLottoRanking() {
        //given
        WinningStatistics winningStatistics = new WinningStatistics();
        int expectedCount = 1;

        //when
        int actualCount = winningStatistics.addLottoRanking(LottoRanking.FIRST_PRIZE);

        //then
        assertThat(actualCount).isEqualTo(expectedCount);
    }

    @Test
    public void calculateReturnRate() {
        //given
        WinningStatistics winningStatistics = new WinningStatistics();
        winningStatistics.addLottoRanking(LottoRanking.FIFTH_PRIZE);
        double expectedReturnRate = 0.35;
        //when
        double actualReturnRate = winningStatistics.calculateRateOfReturn(14_000);
        //then
        assertThat(actualReturnRate).isEqualTo(expectedReturnRate, withPrecision(0.01d));
    }
}