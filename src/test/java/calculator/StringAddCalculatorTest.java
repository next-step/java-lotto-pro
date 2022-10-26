package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

    @DisplayName("숫자가 null 또는 \"\"인 경우 0 반환")
    @ParameterizedTest(name = "#{index} - |{0}| 은 0이다.")
    @NullSource
    @ValueSource(strings = {"", " ", "  "})
    public void splitAndSum_null_또는_빈문자(String input) {
        int result = StringAddCalculator.splitAndSum(input);
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("단일 문자숫자인 경우 숫자 반환")
    @ParameterizedTest(name = "#{index} - 문자 \"{0}\"은 {1}로 반환된다.")
    @CsvSource(value = {"1=1", "3=3", "5=5"}, delimiter = '=')
    public void splitAndSum_숫자하나(String input, int expected) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("쉼표 구분자인 경우 숫자 합")
    @ParameterizedTest(name = "#{index} - \"{0}\"의 합은 {1}이다.")
    @CsvSource(value = {"1,2,3=6", "1,2,3,4=10", "4,3,2,1=10"}, delimiter = '=')
    public void splitAndSum_쉼표구분자(String input, int expected) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("쉼표 또는 콜론 구분자인 경우 숫자 합")
    @ParameterizedTest(name = "#{index} - \"{0}\"의 합은 {1}이다.")
    @CsvSource(value = {"1,2:3=6", "1:2:3,4=10", "4,3:2:1=10"}, delimiter = '=')
    public void splitAndSum_쉼표_또는_콜론_구분자(String input, int expected) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자인 경우 숫자의 합")
    @ParameterizedTest(name = "#{index} - \"{0}\"의 합은 {1}이다.")
    @MethodSource("custom_delimiter_sum")
    public void splitAndSum_custom_구분자(String input, int expected) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> custom_delimiter_sum() {
        return Stream.of(
                Arguments.of("//!\n1!2:3!4", 10),
                Arguments.of("//@\n1@2@3,3", 9),
                Arguments.of("//x\n1x2:3,3", 9)
        );
    }

    @DisplayName("음수가 오는 경우 Exception 발생")
    @ParameterizedTest(name = "#{index} - \"{0}\"의 해당 조합으로는 합을 구할 수 없다.")
    @ValueSource(strings = {"1,2,-3", "a,2,3,4", "4,-2,a,1", "-1:-2"})
    public void splitAndSum_negative(String input) {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }

}