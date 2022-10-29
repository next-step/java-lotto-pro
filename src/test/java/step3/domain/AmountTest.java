package step3.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static step3.type.ErrorMessageType.INPUT_NOT_ALLOW_NEGATIVE_NUMBER;

class AmountTest {

    @Test
    @DisplayName("음수를 입력한 경우 IllegalArgumentException이 발생한다.")
    void amountNotAllowNegative() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Amount(-1))
                .withMessageContaining(INPUT_NOT_ALLOW_NEGATIVE_NUMBER.getMessage());
    }

    @Test
    @DisplayName("양수를 입력하면 금액 객체가 생성된다.")
    void amountCreateSuccess() {
        Amount amount = new Amount(1000);
        assertThat(amount).isEqualTo(new Amount(1000));
    }
}
