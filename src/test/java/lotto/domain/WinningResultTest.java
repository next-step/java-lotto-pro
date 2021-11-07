package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class WinningResultTest {
    @Test
    @DisplayName("통계가 잘 생성되는지 확인")
    void 통계_생성() {
        WinningResult winningResult = new WinningResult(WinningRank.resultRank(4, true), 3);
        assertThat(winningResult.getTotalReward()).isEqualTo(150000);
    }

    @DisplayName("보너스를 맞춘 2등일때 통계가 잘 생성되는지 확인")
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void 통계_생성_보너스(int count) {
        WinningResult winningResult = new WinningResult(WinningRank.resultRank(5, true), count);
        assertThat(winningResult.getTotalReward()).isEqualTo(count * WinningRank.SECOND_RANK.getReward());
    }

}
