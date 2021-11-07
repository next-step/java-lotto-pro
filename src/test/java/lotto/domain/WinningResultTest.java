package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningResultTest {
    @Test
    @DisplayName("통계가 잘 생성되는지 확인")
    void 통계_생성() {
        WinningResult winningResult = new WinningResult(WinningRank.resultRank(4), 3);
        assertThat(winningResult.getCount()).isEqualTo(3);
        assertThat(winningResult.getWinningRank().getMatchCount()).isEqualTo(4);
        assertThat(winningResult.getWinningRank().getReward()).isEqualTo(50000);
    }

}
