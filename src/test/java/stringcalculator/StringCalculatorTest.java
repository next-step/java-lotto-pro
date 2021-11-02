package stringcalculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2,3"})
    void 쉼표_콜론_구분자(String inputString) {
        assertThat(StringCalculator.separator(inputString)).containsExactly("1", "2", "3");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//a\n1a2a3"})
    void 커스텀_구분자(String inputString) {
        assertThat(StringCalculator.customSeparator(inputString)).containsExactly("1", "2", "3");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,2,3", "-1,1,3"})
    void 숫자_이외의값_에러처리(String inputString) {
        assertThatThrownBy(() ->
                StringCalculator.calculate(inputString))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    void 빈값_0처리() {
        assertThat(StringCalculator.calculate("")).isEqualTo(0);
    }

    @Test
    void null_0처리() {
        assertThat(StringCalculator.calculate(null)).isEqualTo(0);
    }

    @Test
    void 숫자_하나_처리() {
        assertThat(StringCalculator.calculate("1")).isEqualTo(1);
    }

    @ParameterizedTest
    @CsvSource(value = {"'1,2,3', 6", "'3:4,5', 12", "'//;\n1;2;3', 6", "'//;\n1,2;3;5:7', 18"})
    void 문자열계산기(String inputString, int result) {
        assertThat(StringCalculator.calculate(inputString)).isEqualTo(result);
    }
}
