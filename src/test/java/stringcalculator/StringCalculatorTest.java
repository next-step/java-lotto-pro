package stringcalculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2,3"})
    void 쉼표_콜론_구분자(String inputString) {
        Assertions.assertThat(StringCalculator.separator(inputString)).containsExactly("1", "2", "3");
    }
}
