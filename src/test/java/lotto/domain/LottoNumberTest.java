package lotto.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class LottoNumberTest {
    @Test
    void 유효한범위의_숫자가아니면_예외를발생시킨다() {
        assertThatThrownBy(() -> new LottoNumber(0)).isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(() -> new LottoNumber(46)).isInstanceOf(IllegalStateException.class);
    }

    @Test
    void 로또번호_같은지_확인하기() {
        assertThat(new LottoNumber(3)).isEqualTo(new LottoNumber(3));
    }
}