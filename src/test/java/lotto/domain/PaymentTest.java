package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PaymentTest {

    @DisplayName("지불금액이 1000원 미만이면 IllegalArgumentException을 발생시킨다.")
    @ParameterizedTest
    @ValueSource(ints = {-500, 0, 999})
    void validate(int payment) {
        assertThatThrownBy(() -> Payment.from(payment))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
