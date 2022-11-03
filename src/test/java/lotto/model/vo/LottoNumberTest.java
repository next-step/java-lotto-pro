package lotto.model.vo;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoNumberTest {

    @DisplayName("로또 숫자 유효성 확인")
    @ParameterizedTest
    @CsvSource({"0,false", "1,true", "45,true", "47,false"})
    void 로또_숫자_유효성(int checkValue, boolean expected) {
        assertThat(LottoNumber.validateNumber(checkValue)).isEqualTo(expected);
    }

    @DisplayName("로또 숫자 일치 확인")
    @Test
    void 로또_숫자_일치() {
        LottoNumber number1 = new LottoNumber(1);
        LottoNumber number2 = new LottoNumber(1);
        LottoNumber number3 = new LottoNumber(2);
        assertThat(number1.equals(number2)).isTrue();
        assertThat(number1.equals(number3)).isFalse();
    }
}
