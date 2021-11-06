package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningStatisticTest {
    @Test
    @DisplayName("통계가 잘 생성되는지 확인")
    void 통계_생성() {
        WinningStatistic winningStatistic = new WinningStatistic(WinningRank.result(4), 3);
        assertThat(winningStatistic.getCount()).isEqualTo(3);
        assertThat(winningStatistic.getWinningRank().getMatchCount()).isEqualTo(4);
        assertThat(winningStatistic.getWinningRank().getReward()).isEqualTo(50000);
    }

}
