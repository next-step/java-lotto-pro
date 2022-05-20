import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(strings = { "1", "2", "45" })
    void LottoNumber_는_1_에서_45_사이의_숫자범위를_가질_수_있다(String number) {
        assertDoesNotThrow(() -> new LottoNumber(number));
    }

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

    @ParameterizedTest
    @ValueSource(strings = { "0", "46", "" + Integer.MIN_VALUE, "" + Integer.MAX_VALUE })
    void LottoNumber_는_1_에서_45_사이의_숫자범위를_벗어난_문자열을_받으면_예외를_던진다(String number) {
        assertThatThrownBy(() -> new LottoNumber(number)).isInstanceOf(RuntimeException.class);
    }

    @Test
    void LottoNumber_는_값_객체이다() {
        int number = 1;
        assertThat(new LottoNumber(number)).isEqualTo(new LottoNumber(number));
    }
}
