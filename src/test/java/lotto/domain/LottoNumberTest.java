package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {

    @ParameterizedTest()
    @ValueSource(ints = {-1, -10, 46, 55})
    void 영_이하_사십오_이상_범위_예외(int input) {
        assertThatThrownBy(() -> LottoNumber.from(input)).isInstanceOf(IllegalArgumentException.class);
    }

}