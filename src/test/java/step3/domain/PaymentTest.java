package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentTest {

    @Test
    @DisplayName("수익률 조회")
    public void testGetWinningMoneyRate() {
        long winningMoney = 100L;
        Money payment = Money.generate(1000L);
        String winningMoneyRate = payment.rate(winningMoney);
        assertThat(Float.parseFloat(winningMoneyRate))
                .isEqualTo(0.1f);
    }
}
