package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoNumberTest {

    @DisplayName("로또 숫자 생성 캐싱적용 확인")
    @Test
    void 로또_숫자_생성() {
        LottoNumber number = LottoNumber.getLottoNumberByInt(5);
        assertThat(LottoNumber.getLottoNumberByInt(5)).isEqualTo(number);
        assertThat(LottoNumber.getLottoNumberByInt(5) == number).isTrue();
    }

    @DisplayName("로또 숫자 유효성 확인")
    @ParameterizedTest
    @CsvSource({"0,false", "1,true", "45,true", "47,false"})
    void 로또_숫자_유효성(int checkValue, boolean expected) {
        assertThat(LottoNumber.validateNumber(checkValue)).isEqualTo(expected);
    }

    @DisplayName("로또 숫자 일치 확인")
    @Test
    void 로또_숫자_일치() {
        LottoNumber number1 = LottoNumber.getLottoNumberByInt(1);
        LottoNumber number2 = LottoNumber.getLottoNumberByInt(1);
        LottoNumber number3 = LottoNumber.getLottoNumberByInt(2);
        assertThat(number1.equals(number2)).isTrue();
        assertThat(number1.equals(number3)).isFalse();
    }
}
