package calculator;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {
    @DisplayName("null 또는 빈문자는 0을 반환한다.")
    @Test
    void splitAndSum_null_또는_빈문자() {
        assertAll(
                () -> assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0),
                () -> assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0)
        );
    }

    @DisplayName("숫자 하나를 문자열로 입력받은 경우 해당 숫자를 반환한다.")
    @ParameterizedTest(name = "숫자 {0}를 문자열로 입력받은 경우 {1} 숫자 반환한다.")
    @CsvSource(value = {"1:1", "2:2", "3:3", "15:15"}, delimiter = ':')
    void splitAndSum_숫자하나(String input, int expect) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 숫자의 합을 반환한다.")
    @ParameterizedTest(name = "숫자 {0}를 컴마(,) 구분자로 입력할 경우 합 {1}을 반환한다.")
    @CsvSource(value = {"1,2:3", "2,2:4", "3,0:3", "15,15:30", "1,2,3:6"}, delimiter = ':')
    void splitAndSum_쉼표구분자(String input, int expect) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("컴마(,), 콜론(:) 구분자로 숫자의 합을 반환한다.")
    @ParameterizedTest(name = "숫자 {0}를 컴마(,), 콜론(:) 구분자로 입력할 경우 합 {1}을 반환한다.")
    @CsvSource(value = {"1:2/3", "2:2/4", "3:0,3/6", "15,15:70/100", "1,2:2:3/8"}, delimiter = '/')
    void splitAndSum_쉼표_또는_콜론_구분자(String input, int expect) throws Exception {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(expect);
    }

    @DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자로 숫자합을 반환한다")
    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        assertAll(
                () -> assertThat(StringAddCalculator.splitAndSum("//;\n1;2;3")).isEqualTo(6),
                () -> assertThat(StringAddCalculator.splitAndSum("//q\n1q3q3")).isEqualTo(7)
        );
    }

    @DisplayName("음수를 포함한 문자열을 전달하면 RuntimeException 예외가 발생한다.")
    @ParameterizedTest(name = "음수를 포함한 {0}를 전달하면 RuntimeException 예외가 발생한다.")
    @ValueSource(strings = {"3,-1", "-1:-1", "1:2:-3"})
    public void splitAndSum_negative(String input) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("음수가 입력되었습니다. 0 이상 값을 입력해주세요.");
    }

    @DisplayName("숫자가 아닌 값이 포함된 문자열을 전달하면 RuntimeException 예외가 발생한다.")
    @ParameterizedTest(name = "숫자가 아닌 값이 포함된 문자열 {0}를 전달하면 RuntimeException 예외가 발생한다.")
    @ValueSource(strings = {"3,p", ":3", "1::3", "e:rr:or"})
    public void splitAndSum_not_number(String input) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("숫자 이외의 값이 입력되었습니다. 숫자를 입력해주세요.");
    }
}
