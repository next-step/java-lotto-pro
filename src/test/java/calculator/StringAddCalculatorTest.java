package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {
    @Test
    @DisplayName("Calculator는 null을 받을 경우 0을 반환한다")
    void calculator_on_null() {
        Integer sum = StringAddCalculator.splitAndSum(null);
        assertThat(sum).isEqualTo(0);
    }

    @Test
    @DisplayName("Calculator는 빈 값을 받을 경우 0을 반환한다")
    void calculator_on_empty() {
        Integer sum = StringAddCalculator.splitAndSum("");
        assertThat(sum).isEqualTo(0);
    }

    @Test
    @DisplayName("Calculator는 음수로 된 문자열을 받을 경우 RuntimeException이 발생된다")
    void calculator_on_negative_value() {
        String string = "-2";

        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(string))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    @DisplayName("Calculator는 숫자가 아닌 문자열을 받을 경우 RuntimeException이 발생된다")
    void calculator_on_non_number_value() {
        String string = "가";

        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(string))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("[ERROR]");
    }


    @ParameterizedTest
    @ValueSource(strings = {"1,2,3", "1:2:3", "1:2,3", "1,2,3"})
    @DisplayName("Calculator는 기본 구분자로 된 문자열을 받을 경우 합산한 결과를 반환한다")
    void calculator_on_default_delimiter_value(String string) {
        Integer sum = StringAddCalculator.splitAndSum(string);

        assertThat(sum).isEqualTo(6);
    }

    @ParameterizedTest
    @ValueSource(strings = {"//;\n1;2;3", "//-\n1-2-3", "//_\n1_2_3"})
    @DisplayName("Calculator는 커스텀 구분자로 된 문자열을 받을 경우 합산한 결과를 반환한다")
    void calculator_on_custom_delimiter_value(String string) {
        Integer sum = StringAddCalculator.splitAndSum(string);

        assertThat(sum).isEqualTo(6);
    }

    // BELOW IS PROVIDED TEST CASES.

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
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
