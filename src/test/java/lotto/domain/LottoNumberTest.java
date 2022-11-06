package lotto.domain;

import lotto.common.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @Test
    @DisplayName("로또_번호_생성")
    void 로또_번호_생성() {
        assertThat(LottoNumber.valueOf(1)).isEqualTo(LottoNumber.valueOf(1));
    }

    @Test
    @DisplayName("로또_번호_범위_채크")
    void 로또_번호_범위_채크() {
        assertThatThrownBy(() -> LottoNumber.valueOf(0))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_LOTTO_NUMBER_OUT_OF_RANGE);
        assertThatThrownBy(() -> LottoNumber.valueOf(46))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ERROR_LOTTO_NUMBER_OUT_OF_RANGE);
    }
}
