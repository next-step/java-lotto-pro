package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @ParameterizedTest
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다")
    @NullAndEmptySource
    void empty_or_null_should_be_return_zero(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isZero();

    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    void when_single_number_as_string_that_number_return(String input, int expect) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expect);
    }

    @Test
    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환")
    void two_number_enter_with_comma_delimiter_then_sum_of_two_number_return() {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

    @Test
    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다")
    void colon_can_be_used_delimiter() {
        int result = StringAddCalculator.splitAndSum("1,2:3");
        assertThat(result).isEqualTo(6);
    }
    @Test
    @DisplayName("'//'와 '\\n' 문자 사이에 커스텀 구분자를 쓸 수 있다.")
    void can_use_custom_delimiter() {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생")
    void if_enter_negative_number_then_error_occur() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("음수는 입력할 수 없습니다.");
    }
    @Test
    @DisplayName("숫자가 아닌 문자를 입력하는 경우 RuntimeException 예외가 발생")
    void if_enter_non_numeric_character_then_error_occur() {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum("A,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자가 아닙니다.");
    }
}
