package study.step2.domain.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringAddCalculatorTest {

    @Test
    @DisplayName("Text 값이 Null 또는 빈문자인경우 [0]값을 반환한다")
    void splitAndSum_null_or_empty_text() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    @DisplayName("Text 값이 숫자하나만 있을경우 [해당값] 그대로 반환한다")
    public void splitAndSum_one_number_test() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    @DisplayName("Text 값을 쉼표 구분자로 분리 후 합계를 계산하여 반환한다")
    public void splitAndSum_comma_delimiter_test() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("Text 값을 쉼표 또는 콜론 구분자로 분리 후 합계를 계산하여 반환한다")
    public void splitAndSum_comma_or_colon_delimiter_test() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("Text 값을 Custom 구분자로 분리 후 합계를 계산하여 반환한다")
    public void splitAndSum_custom_delimiter_test() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("Text 값에 음수값이 있을경우 [RuntimeException] 예외처리한다")
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(RuntimeException.class);
    }
}