package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 덧셈 계산기를 통한 TDD/리팩토링 실습")
public class StringAddCalculatorTest {

    @DisplayName("null 또는 빈문자 확인")
    @Test
    public void splitAndSum_null_or_empty() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isZero();

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isZero();
    }

    @DisplayName("하나의 숫자 계산 확인")
    @Test
    public void splitAndSum_number() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("쉼표 구분자로 숫자 계산 확인")
    @Test
    public void splitAndSum_comma() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @DisplayName("쉼표, 콜론 구분자로 숫자 계산 확인")
    @Test
    public void splitAndSum_comma_or_colon() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자로 숫자 계산 확인")
    @Test
    public void splitAndSum_custom() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수 값 런타임 에러 확인")
    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(RuntimeException.class);
    }
}
