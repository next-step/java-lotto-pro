package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.Collections;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningRanksTest {
    @Test
    @DisplayName("로또 수익률을 구한다")
    void lotto_calculate_earning_rate() {
        WinningRanks winningRanks = WinningRanks.of(Arrays.asList(WinningRank.FIFTH, WinningRank.FOURTH));
        assertThat(winningRanks.calculateEarningRatio(new LottoPurchaseAmount(new Money(100000))))
                .isEqualTo(0.55);
    }

    @Test
    @DisplayName("당첨 통계를 반환한다")
    void statistics() {
        WinningRanks winningRanks = WinningRanks.of(Collections.singletonList(WinningRank.SECOND));
        assertThat(winningRanks.statistics()).isEqualTo("3개 일치 (5000원)- 0개\n"
                + "4개 일치 (50000원)- 0개\n"
                + "5개 일치 (1500000원)- 0개\n"
                + "5개 일치, 보너스 볼 일치(30000000원)- 1개\n"
                + "6개 일치 (2000000000원)- 0개\n");
    }
}
