package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ValidateTest {
    @Test
    void InputView_inputPay_문자열_입력() {
        assertThatThrownBy(() -> Validate.validatePay("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void InputView_inputPay_음수_입력() {
        assertThatThrownBy(() -> Validate.validatePay("-10000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void InputView_inputPay_특수문자_입력() {
        assertThatThrownBy(() -> Validate.validatePay("*?/+"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
