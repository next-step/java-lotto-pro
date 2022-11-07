package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfitTest {

    @DisplayName("수익률 계산")
    @Test
    void 수익률_계산() {
        long buyAmount = 14000;
        long winAmount = 5000;
        double expected = 0.35;
        Profit profit = new Profit(buyAmount, winAmount);
        assertThat(profit.getProfit()).isEqualTo(expected);
    }
}
