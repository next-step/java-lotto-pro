package lotto.model;

import static lotto.model.Payment.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class PaymentTest {
    @ParameterizedTest
    @DisplayName("지불 금액이 " + LOTTO_PRICE + "원 미만이거나 " + LOTTO_PRICE + "으로 나누어 떨어지지 않을 때 예외 발생")
    @ValueSource(ints = {LOTTO_PRICE - 1, LOTTO_PRICE + 1})
    void 객체_생성_시_유효성_검사(int money) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Payment(money));
    }

    @Test
    void getLottoCount() {
        assertThat(new Payment(14000).getLottoCount()).isEqualTo(14000 / LOTTO_PRICE);
    }

    @Test
    void equals() {
        assertThat(new Payment(2000)).isEqualTo(new Payment(2000));
    }
}
