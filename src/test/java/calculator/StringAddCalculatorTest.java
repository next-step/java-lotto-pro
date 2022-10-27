package calculator;

import calculator.StringAddCalculator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class StringAddCalculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "99"})
    public void splitAndSum_숫자하나(String input) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(Integer.parseInt(input));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2|3", "1,3,7,8,102|121"}, delimiter = '|')
    public void splitAndSum_쉼표구분자(String input, int sum) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(sum);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2|3", "1,3,7,8,102|121"}, delimiter = '|')
    public void splitAndSum_쉼표_또는_콜론_구분자(String input, int sum) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(sum);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//d\n1d2d3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_단일_값이_아닌_custom_구분자() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//;;\n1;;2;;3"))
                .isInstanceOf(RuntimeException.class);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3:a", "//;\n1;a;3"})
    public void splitAndSum_character(String input) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }

}
