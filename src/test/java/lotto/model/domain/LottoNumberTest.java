package lotto.model.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import lotto.model.constants.LottoConstants;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoNumberTest {

    @DisplayName("로또 숫자 생성 캐싱적용 확인")
    @Test
    void 로또_숫자_생성() {
        LottoNumber number = LottoNumber.getLottoNumberByInt(5);
        assertThat(LottoNumber.getLottoNumberByInt(5)).isEqualTo(number);
        assertThat(LottoNumber.getLottoNumberByInt(5) == number).isTrue();
    }

    @DisplayName("로또 숫자 유효하지 않은 경우 예외처리")
    @Test
    void 로또_숫자_유효성() {
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoNumber.validateNumber(LottoConstants.LOTTO_NUMBER_MIN-1);
        });
        LottoNumber.validateNumber(LottoConstants.LOTTO_NUMBER_MIN);
        LottoNumber.validateNumber(LottoConstants.LOTTO_NUMBER_MAX);
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() -> {
            LottoNumber.validateNumber(LottoConstants.LOTTO_NUMBER_MAX+1);
        });
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
