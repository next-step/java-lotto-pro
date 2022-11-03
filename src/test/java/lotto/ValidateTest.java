package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

public class ValidateTest {
    @Test
    void 로또_구입금액_보다_적은_금액_입력() {
        assertThatThrownBy(() -> Validate.validatePay("500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 공백_입력() {
        assertThatThrownBy(() -> Validate.validateCostNull(""))
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

    @Test
    void 당첨_번호중_중복된_번호_검사() {
        assertThatThrownBy(() -> Validate.validateWinningNumberDuplicate("1, 1, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호와_당첨_번호간에_중복_검사() {
        assertThatThrownBy(
                () -> Validate.validateBonusNumberDuplicate(1, new ArrayList<>(
                        Arrays.asList(new LottoNumber(1),
                                new LottoNumber(2),
                                new LottoNumber(3),
                                new LottoNumber(4),
                                new LottoNumber(5),
                                new LottoNumber(6)))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
