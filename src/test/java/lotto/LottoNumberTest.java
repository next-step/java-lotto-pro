package lotto;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    public void 숫자_예외_테스트(int input) {
        assertThatThrownBy(() -> new LottoNumber(input)).isInstanceOf(IllegalArgumentException.class);
    }
}
