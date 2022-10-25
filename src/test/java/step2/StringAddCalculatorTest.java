package step2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_또는_빈문자(String calculatorText) {
        int result = StringAddCalculator.splitAndSum(calculatorText);
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    public void splitAndSum_숫자하나(String calculatorText) throws Exception {
        int result = StringAddCalculator.splitAndSum(calculatorText);
        assertThat(result).isEqualTo(Integer.parseInt(calculatorText));
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2/3", "2,3/5", "1,3/4"}, delimiter = '/')
    public void splitAndSum_쉼표구분자(String calculatorText, int sumResult) throws Exception {
        int result = StringAddCalculator.splitAndSum(calculatorText);
        assertThat(result).isEqualTo(sumResult);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3/6", "1,1:4,3/9", "1,3:4/8"}, delimiter = '/')
    public void splitAndSum_쉼표_또는_콜론_구분자(String calculatorText, int sumResult) throws Exception {
        int result = StringAddCalculator.splitAndSum(calculatorText);
        assertThat(result).isEqualTo(sumResult);
    }

    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }

}
