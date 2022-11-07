package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.model.vo.Lotto;
import lotto.model.vo.LottoNumber;
import lotto.model.vo.WinLotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoRunTest {

    @DisplayName("수익률 계산")
    @Test
    void 수익률_계산() {
        long buyAmount = 14000;
        long winAmount = 5000;
        double expected = 0.35;
        assertThat(LottoRun.calculateProfit(buyAmount, winAmount)).isEqualTo(expected);
    }

}
