package stringaddcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class InputStringTest {

    @Test
    void 기본_구분자로_숫자를_구분한다() {
        assertAll(
                () -> assertThat(new InputString("1,2").getNumbers()).containsExactly(1, 2),
                () -> assertThat(new InputString("1:2").getNumbers()).containsExactly(1, 2)
        );

    }

    @ParameterizedTest
    @CsvSource(value = {"null", "''"}, nullValues = {"null"})
    void 빈문자열_또는_null인_경우에는_0을_반환(String input) {
        assertThat(new InputString(input).getNumbers()).containsExactly(0);
    }

    @Test
    void 숫자_하나만_입력되면_해당_숫자_반환() {
        assertThat(new InputString("1").getNumbers()).containsExactly(1);
    }

    @Test
    void 커스텀_구분자로_숫자를_구분한다() {
        assertThat(new InputString("//;\n1;2;3").getNumbers()).containsExactly(1, 2, 3);
    }

    @ParameterizedTest
    @ValueSource(strings = {"가", "1,가"})
    void 숫자이외의_값이_입력될때_runtimeException_발생(String value) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> new InputString(value));
    }
}
