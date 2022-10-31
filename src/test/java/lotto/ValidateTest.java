package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class ValidateTest {
    @Test
    void 로또_구입금액_보다_적은_금액_입력() {
        assertThatThrownBy(() -> Validate.validatePay("500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_입력() {
        assertThatThrownBy(() -> Validate.validateNull(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_입력() {
        assertThatThrownBy(() -> Validate.validateOnlyNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_입력() {
        assertThatThrownBy(() -> Validate.validateOnlyNumber("-10000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 특수문자_입력() {
        assertThatThrownBy(() -> Validate.validateOnlyNumber("*?/+"))
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

    @Test
    void 당첨_번호를_문자열만_입력() {
        assertThatThrownBy(() -> Validate.validateWinningNumber("a, b, c, d, e, f"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호에_문자열_포함() {
        assertThatThrownBy(() -> Validate.validateWinningNumber("1, 2, 3, d, e, f"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_5개만_입력() {
        assertThatThrownBy(() -> Validate.validateWinningNumberCount("1, 2, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
