package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

public class ValidateTest {
    @Test
    void 로또_구입금액_보다_적은_금액_입력() {
        assertThatThrownBy(() -> Validate.isPurchasable("500"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @NullAndEmptySource
    void 공백_또는_null_입력(String input) {
        assertThatThrownBy(() -> Validate.isEmpty(input)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 문자열_입력() {
        assertThatThrownBy(() -> Validate.isNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 음수_입력() {
        assertThatThrownBy(() -> Validate.isNumber("-10000"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 특수문자_입력() {
        assertThatThrownBy(() -> Validate.isNumber("*?/+"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_범위를_초과한_입력() {
        assertThatThrownBy(() -> Validate.isOutOfBound(100))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력_범위를_초과한_입력_2() {
        assertThatThrownBy(() -> Validate.isOutOfBound(0))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_5개만_입력() {
        assertThatThrownBy(() -> Validate.isSixNumbers(Arrays.asList(1, 2, 3, 4, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호중_중복된_번호_검사() {
        assertThatThrownBy(() -> Validate.isDuplicate("1, 1, 3, 4, 5"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호와_당첨_번호간에_중복_검사() {
        List<LottoNumber> lottoNumbers = new ArrayList<>();
        for (int i = 1; i <= 6; i++) {
            lottoNumbers.add(LottoNumber.from(i));
        }

        assertThatThrownBy(
                () -> Validate.isDuplicate(LottoNumber.from(1), lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 수동으로_구입하려하는_로또_금액이_지불한_금액을_초과하는_경우() {
        assertThatThrownBy(() -> Validate.isPurchasable(1000, Quantity.from(2))).isInstanceOf(
                IllegalArgumentException.class);
    }
}
