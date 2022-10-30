package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningRanksTest {
    @Test
    @DisplayName("로또 수익률을 구한다")
    void lotto_calculate_earning_rate() {
        WinningRanks winningRanks = WinningRanks.of(Arrays.asList(WinningRank.FIFTH, WinningRank.FOURTH));
        assertThat(winningRanks.calculateEarningRatio(new LottoPurchaseAmount("100000")))
                .isEqualTo(0.55);
    }
}
