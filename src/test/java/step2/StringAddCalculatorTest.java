package step2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("문자열 덧셈 계산기를 통한 TDD/리팩토링 실습")
public class StringAddCalculatorTest {

    @DisplayName("입력 값이 null 또는 빈문자인 경우 0을 반환하는지 확인")
    @ParameterizedTest
    @NullAndEmptySource
    public void splitAndSum_null_or_empty(String input) {
        int result = StringAddCalculator.splitAndSum(input);

        assertThat(result).isZero();
    }

    @DisplayName("입력 값이 하나의 숫자인 경우 반환하는지 확인")
    @Test
    public void splitAndSum_number(String input) throws Exception {
        int result = StringAddCalculator.splitAndSum("1");

        assertThat(result).isEqualTo(1);
    }

    @DisplayName("쉼표 구분자로 구분된 경우 쉼표 구분자로 분리해 계산 확인")
    @Test
    public void splitAndSum_comma() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");

        assertThat(result).isEqualTo(3);
    }

    @DisplayName("쉼표, 콜론 구분자로 구분된 경우 쉼표, 콜론 구분자로 분리해 숫자 계산 확인")
    @Test
    public void splitAndSum_comma_or_colon() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2:3");

        assertThat(result).isEqualTo(6);
    }

    @DisplayName("커스텀 구분자로 구분된 경우 커스텀 구분자로 분리해 숫자 계산 확인")
    @Test
    public void splitAndSum_custom() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");

        assertThat(result).isEqualTo(6);
    }

    @DisplayName("음수 값이 입력된 경우 런타임 에러가 발생되는지 확인")
    @Test
    public void splitAndSum_negative() throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
