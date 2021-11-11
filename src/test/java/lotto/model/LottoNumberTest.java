package lotto.model;

import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {

    @DisplayName("로또 경계 숫자 객체 생성 검증")
    @Test
    void lottoNumber() {
        LottoNumber lottoNumber = new LottoNumber(1);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(1));

        lottoNumber = new LottoNumber(45);
        assertThat(lottoNumber).isEqualTo(new LottoNumber(45));
    }

    @DisplayName("로또 숫자의 범위 검증")
    @Test
    void lottoNumberRange() {
        assertThatThrownBy(() -> {
            new LottoNumber(46);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_RANGE_OVER);

        assertThatThrownBy(() -> {
            new LottoNumber(0);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LOTTO_RANGE_OVER);
    }
}
