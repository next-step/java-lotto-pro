package lotto;

import lotto.domain.Money;
import lotto.domain.WinningStatistic;
import lotto.enums.Rank;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatisticTest {

    @Test
    void 당첨_순위를_넘겨주어_당첨금_통계를_낸다() {
        // given
        WinningStatistic winningStatistic = new WinningStatistic();
        // when
        winningStatistic.collect(Rank.FIRST);
        // then
        assertThat(winningStatistic.count(Rank.FIRST)).isEqualTo(1);
    }

    @Test
    void 수익률을_계산한다() {
        // given
        WinningStatistic winningStatistic = new WinningStatistic();
        winningStatistic.collect(Rank.FOUR);
        // when
        double rate = winningStatistic.calculateRateOfReturn(Money.of(14000));
        // then
        assertThat(rate).isEqualTo(0.35);
    }
}