package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2,3"})
    void 쉼표_콜론_구분자(String inputString) {
        Assertions.assertThat(StringCalculator.separator(inputString)).containsExactly("1", "2", "3");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//a\n1a2a3"})
    void 커스텀_구분자(String inputString) {
        Assertions.assertThat(StringCalculator.customSeparator(inputString)).containsExactly("1", "2", "3");
    }

    @ParameterizedTest
    @ValueSource(strings = {"a,2,3", "-1,1,3"})
    void 숫자_이외의값_에러처리(String inputString) {
        Assertions.assertThatThrownBy(() ->
                StringCalculator.calculate(inputString))
                .isInstanceOf(RuntimeException.class);
    }
}
