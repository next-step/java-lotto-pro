package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class WinningStatusTest {

    @Test
    void recordResults() {
        WinningStatus winningStatus = new WinningStatus();
        assertThat(winningStatus.findWinningCount(MatchPoint.THREE)).isEqualTo(0);
    }
}