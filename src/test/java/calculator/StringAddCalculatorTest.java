package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {
    public static Stream<Arguments> args() {
        return Stream.of(
                Arguments.of(
                        "//;\n1;2;3",
                        6
                )
        );
    }

    @DisplayName("빈 문자열 또는 null 값을 입력할 경우 0을 반환테스트")
    @ParameterizedTest
    @NullAndEmptySource
    void splitAndSum_null_또는_빈문자(String input) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환테스트")
    @ParameterizedTest
    @CsvSource({"1,1"})
    public void splitAndSum_숫자하나(String input, int expected) throws Exception {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3"}, delimiter = ':')
    public void splitAndSum_쉼표구분자(String input, int expected) throws Exception {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("구분자를 컴마(,) 이외에 콜론(:)을 사용할 경우 합을 반환테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3=6"}, delimiter = '=')
    public void splitAndSum_쉼표_또는_콜론_구분자(String input, int expected) throws Exception {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("//와 \n 문자 사이에 커스텀 구분자를 지정할 경우 합을 반환테스트")
    @ParameterizedTest
    @MethodSource("args")
    public void splitAndSum_custom_구분자(String input, int expected) throws Exception {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(expected);
    }

    @DisplayName("음수를 전달할 경우 RuntimeException 예외가 발생테스트")
    @ParameterizedTest
    @ValueSource(strings = {"-1,2,3"})
    public void splitAndSum_negative(String input) throws Exception {
        assertThatThrownBy(() -> StringAddCalculator.splitAndSum(input))
                .isInstanceOf(RuntimeException.class);
    }
}
