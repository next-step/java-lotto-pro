package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottoNumberTest {

    @DisplayName("로또번호는 동일성을 보장한다.")
    @Test
    void of() {
        assertThat(LottoNumber.of(1)).isEqualTo(LottoNumber.of(1));
    }

}
