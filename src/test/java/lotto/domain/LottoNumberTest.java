package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @Test
    void create() {
        LottoNumber number = LottoNumber.from(1);
        assertThat(number).isEqualTo(LottoNumber.from(1));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 46})
    void 입력한_숫자가_1에서_45사이의_이외의_숫자이면_예외(int input) {
        assertThatThrownBy(() ->
                LottoNumber.from(input)).isInstanceOf(IllegalArgumentException.class);
    }

}
