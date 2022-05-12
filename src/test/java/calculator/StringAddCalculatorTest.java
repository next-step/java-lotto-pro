package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

public class StringAddCalculatorTest {

    @ParameterizedTest(name = "null 또는 빈문자 입력시, 0값을 반환한다")
    @ValueSource(strings = {"",})
    public void splitAndSum_null_또는_빈문자(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isZero();
    }

    @ParameterizedTest(name = "숫자하나 {0} 입력시, 입력숫자 {1}를 반환한다")
    @CsvSource(value = {"1|1", "3|3", "5|5"}, delimiter = '|')
    public void splitAndSum_숫자하나(String input, int output) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest(name = "숫자 두개를 컴마(,) 구분자로 {0} 입력할 경우 두 숫자의 합 {1}을 반환한다")
    @CsvSource(value = {"1,2|3", "3,4|7", "5,6|11"}, delimiter = '|')
    public void splitAndSum_쉼표구분자(String input, int output) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(output);
    }

    @ParameterizedTest(name = "구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있으며, {0} 입력할 경우 두 숫자의 합 {1}을 반환한다")
    @CsvSource(value = {"1,2:3|6", "1,1:2|4", "3,3:3|9"}, delimiter = '|')
    public void splitAndSum_쉼표_또는_콜론_구분자(String input, int output) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(output);
    }

    @Test
    @DisplayName(" “//”와 “\\n” 문자 사이에 커스텀 구분자를 지정할 있으며 숫자의 합을 반환한다")
    public void splitAndSum_custom_구분자() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수값 입력시 RuntimeException을 발생시킨다")
    public void splitAndSum_negative() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .withMessageMatching("0보다 작은 수는 허용을 하지 않습니다.");
    }

    @ParameterizedTest(name = "숫자가 아닌값 {0} 을 입력시 RuntimeException을 발생시킨다")
    @ValueSource(strings = {"a;b;c", "1:2:a", "a:1:a"})
    public void splitAndSum_숫자아닌값() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> StringAddCalculator.splitAndSum("a;b;c"))
                .withMessageMatching("올바르지 않는 숫자 입니다.");
    }
}
