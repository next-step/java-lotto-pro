package lotto;

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
}