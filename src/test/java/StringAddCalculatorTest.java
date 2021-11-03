import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환")
    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
    @ParameterizedTest
    @ValueSource(strings = {"1", "30", "500", "7000"})
    public void splitAndSum_숫자하나(String inputText) throws Exception {
        int result = StringAddCalculator.splitAndSum(inputText);
        assertThat(result).isEqualTo(Integer.parseInt(inputText));
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환")
    @ParameterizedTest
    @CsvSource(value = {"1,2=3", "30,40=70", "500,600=1100", "7000,8000=15000"}, delimiter = '=')
    public void splitAndSum_쉼표구분자(String inputText, int expectedResult) throws Exception {
        int result = StringAddCalculator.splitAndSum(inputText);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3=6", "30,40:50=120", "500,600:700=1800"}, delimiter = '=')
    public void splitAndSum_쉼표_또는_콜론_구분자(String inputText, int expectedResult) throws Exception {
        int result = StringAddCalculator.splitAndSum(inputText);
        assertThat(result).isEqualTo(expectedResult);
    }

    @DisplayName("“//”와 “\n” 문자 사이에 커스텀 구분자를 지정할 수 있음")
    @Test
    public void splitAndSum_custom_구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("//;\n1;2;3");
        assertThat(result).isEqualTo(6);
    }

    @DisplayName("숫자 이외의 값 또는 음수를 전달할 경우 RuntimeException 예외가 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3", "b,a,-2"})
    public void splitAndSum_negative(String inputText) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(inputText))
                .isInstanceOf(RuntimeException.class);
    }
}
