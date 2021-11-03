package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class LottoNumberTest {

    @Test
    void 로또번호를_생성한다() {
        assertThat(new LottoNumber(1)).isEqualTo(new LottoNumber(1));
    }

    @ParameterizedTest(name = "숫자 {0}은 로또 번호가 될 수 없다")
    @ValueSource(ints = {-1, 0, 46})
    void 로또번호는_1이상_45이하의_숫자만_가진다(int number) {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new LottoNumber(number));
    }
}