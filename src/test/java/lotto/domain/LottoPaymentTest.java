package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoPaymentTest {
    @Test
    @DisplayName("지불 금액과 구매 가능 수량을 파라미터로 Payment 객체가 생성되어야 한다")
    void create() {
        // given
        final int money = 1000;

        // when
        final LottoPayment lottoPayment = new LottoPayment(money, money / 1000);

        // when and then
        assertThat(lottoPayment).isInstanceOf(LottoPayment.class);
        assertThat(lottoPayment).isEqualTo(new LottoPayment(money, 1));
    }
}
