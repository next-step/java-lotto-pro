package lotto.domain.lotto;

import lotto.domain.lotto.LottoNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberTest {

    @Test
    @DisplayName("1 ~ 45 사이의 값으로 로또 번호 객체를 생성한다.")
    void createLottoNumber() {
        //given
        LottoNumber lottoNumber = new LottoNumber(1);

        //when //then
        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }

    @ParameterizedTest(name = "로또 숫자 범위: [{index}] {0}")
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 번호가 1 ~ 45가 아닐 경우 예외가 발생한다.")
    void validateRange(int invalidLottoNumber) {
        //given //when //then
        assertThatThrownBy(() -> new LottoNumber(invalidLottoNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
