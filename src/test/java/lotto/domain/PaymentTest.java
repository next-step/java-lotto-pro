package lotto.domain;

import calculator.StringAddCalculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class PaymentTest {

    @Test
    @DisplayName("구입금액에 문자가 입력된 경우 예외처리")
    void character_included_test() {
        assertThatThrownBy(() -> new Payment("오천원"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입금액이 음수인 경우 예외처리")
    void negative_number_test() {
        assertThatThrownBy(() -> new Payment("-10000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("구입금액에 1000원 미만인 경우 예외처리")
    void payment_less_than_1000_test() {
        assertThatThrownBy(() -> new Payment("400"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
