package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @Test
    void 로또번호를_생성한다() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }
}