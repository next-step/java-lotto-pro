package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PaymentTest {
    @Test
    @DisplayName("지불 금액을 파라미터로 Payment 객체가 생성되어야 한다")
    void create() {
        // given
        final String money = "1000";

        // when and then
        assertThat(new Payment(money)).isInstanceOf(Payment.class);
    }
}
