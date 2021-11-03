package stringaddcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StringAddCalculatorTest {
    @Test
    void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    void splitAndSum_숫자하나() {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2:3", "1,2,3", "1:2:3"})
    void splitAndSum_쉼표_또는_콜론_구분자(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//;\n6"})
    void splitAndSum_custom_구분자(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(6);
    }

    @Test
    void splitAndSum_유효하지_않은_custom_구분자() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//;\n1;2!3;4"))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining(StringAddCalculator.INVALID_CUSTOM_PATTERN_ERR_MSG);
    }

    @Test
    void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining(StringAddCalculator.INVALID_INPUT_ERR_MSG);
    }
}
