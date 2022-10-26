package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈문자가 입력될 경우 0 반환")
    void splitAndSum_null_또는_빈문자(String input) {
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isZero();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:1", "2:2", "3:3", "4:4", "5:5"}, delimiter = ':')
    @DisplayName("숫자 하나가 입력될 경우 해당 숫자 반환")
    void splitAndSum_숫자하나(String input, int expected) {
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "2,6,1:9", "2,5,1,3:11"}, delimiter = ':')
    @DisplayName("구분자(,)를 가지는 문자열의 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환")
    void splitAndSum_쉼표구분자(String input, int expected) {
        int result = StringAddCalculator.calculate(input);
        assertThat(result).isEqualTo(expected);
    }

    @Test
    @DisplayName("구분자(,|:)를 가지는 문자열의 경우 구분자를 기준으로 분리한 각 숫자의 합을 반환")
    void splitAndSum_쉼표_또는_콜론_구분자() {
        int result = StringAddCalculator.calculate("1,2:3");
        assertThat(result).isEqualTo(6);
    }

    @Test
    @DisplayName("//와\n 사이의 구분자는 커스텀 구분자로 해당 구분자를 기준으로 분리한 각 숫자의 합을 반환")
    void splitAndSum_custom_구분자() {
        int result = StringAddCalculator.calculate("//;\n1;2;3");
        assertThat(result).isEqualTo(6);

        int result2 = StringAddCalculator.calculate("//!\n1!2!3!4");
        assertThat(result2).isEqualTo(10);
    }

    @Test
    @DisplayName("음수를 전달하는 경우 RuntimeException 예외를 throw")
    void splitAndSum_negative() {
        assertThatThrownBy(() -> StringAddCalculator.calculate("-1,2,3"))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("음수는 입력 불가능 합니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = {" ,2,3", "d,2,3"})
    @DisplayName("숫자 이외의 값을 전달하는 경우 RuntimeException 예외를 throw")
    void splitAndSum_only_number(String input) {
        assertThatThrownBy(() -> StringAddCalculator.calculate(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage("숫자 이외의 값은 입력 불가능합니다.");
    }
}