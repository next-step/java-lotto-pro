package lotto.domain;

import lotto.constants.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class LottoNumberTest {
    @DisplayName("로또 번호 생성")
    @Test
    void test_로또_번호_생성() {
        //given
        LottoNumber lottoNumber = new LottoNumber(1);
        //when & then
        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));
    }

    @DisplayName("범위를 벗어난 로또 번호 생성 시 예외 처리")
    @Test
    void test_범위를_벗어난_로또_번호_생성() {
        //given & when & then
        assertThatThrownBy(() -> new LottoNumber(46))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessage(ErrorMessage.OUT_OF_RANGE_NUMBER);
    }
}