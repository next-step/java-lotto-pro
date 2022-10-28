package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoNumberValidatorTest {

    @Test
    @DisplayName("번호가 로또 번호의 범주가 아닐 경우 false를 반환해야 한다")
    void isLottoNumberRange_return_false_if_not_lotto_range() {
        // given
        int number = 46;

        // when
        boolean result = LottoNumberValidator.isLottoNumberRange(number);

        // then
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("번호가 로또 번호의 범주일 경우 true를 반환해야 한다")
    void isLottoNumberRange_return_false_if_lotto_range() {
        // given
        int number = 45;

        // when
        boolean result = LottoNumberValidator.isLottoNumberRange(number);

        // then
        assertThat(result).isTrue();
    }
}
