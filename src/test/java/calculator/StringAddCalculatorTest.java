package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {
    @DisplayName("splitAndSum null 또는 빈문자")
    @Test
    void splitAndSumNullOrEmptyString() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("splitAndSum 숫자 하나")
    @ParameterizedTest
    @ValueSource(strings = {"1", "23", "3", "4", "5"})
    void splitAndSumSingleNumber(String text) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(Integer.parseInt(text));
    }

    @DisplayName("splitAndSum 쉼표구분자")
    @ParameterizedTest
    @CsvSource(value = {"1,2-3", "1,5,2-8", "1,17,53-71"}, delimiter = '-')
    void splitAndSumRestDelimiter(String text, int sum) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(sum);
    }

    @DisplayName("splitAndSum 쉼표 또는 콜론 구분자")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3-6", "1,5,2:8-16", "1,17:71-89"}, delimiter = '-')
    void splitAndSumRestOrColonDelimiter(String text, int sum) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(sum);
    }

    @DisplayName("splitAndSum custom 구분자")
    @Test
    void splitAndSumCustomDelimiter() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("splitAndSum negative")
    @Test
    void splitAndSumNegative() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }

    @DisplayName("splitAndSum 문자 포함")
    @Test
    void splitAndSumString() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("a,2,3"))
            .isInstanceOf(RuntimeException.class);
    }
}
