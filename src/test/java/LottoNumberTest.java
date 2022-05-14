import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 45 })
    void LottoNumber_는_1_에서_45_사이의_숫자범위를_가질_수_있다(int number) {
        assertDoesNotThrow(() -> new LottoNumber(number));
    }

    @ParameterizedTest
    @ValueSource(ints = { 0, 46, Integer.MIN_VALUE, Integer.MAX_VALUE })
    void LottoNumber_는_1_에서_45_사이의_숫자범위를_벗어난_숫자를_받으면_예외를_던진다(int number) {
        assertThatThrownBy(() -> new LottoNumber(number)).isInstanceOf(RuntimeException.class);
    }
}
