package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ValidateTest {
    @Test
    void 로또_구입금액_보다_적은_금액_입력() {
        assertThatThrownBy(() -> Validate.validatePay(500))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_입력() {
        assertThatThrownBy(() -> Validate.validateInput("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_입력() {
        assertThatThrownBy(() -> Validate.validateInput("-10000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 특수문자_입력() {
        assertThatThrownBy(() -> Validate.validateInput("*?/+"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_범위를_초과한_입력() {
        assertThatThrownBy(() -> Validate.validateNumberRange(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_범위를_초과한_입력_2() {
        assertThatThrownBy(() -> Validate.validateNumberRange(0))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
