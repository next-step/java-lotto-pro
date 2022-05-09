package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {

    @Test
    @DisplayName("입력값이 null이거나 빈 문자열일 경우 0을 반환")
    void inputNullOrBlank() {
        int blankString1 = StringAddCalculator.input("");
        int blankString2 = StringAddCalculator.input(" ");
        int nullString = StringAddCalculator.input(null);

        assertAll(
                () -> assertThat(blankString1).isZero(),
                () -> assertThat(blankString2).isZero(),
                () -> assertThat(nullString).isZero()
        );
    }

    @Test
    @DisplayName("입력값이 0 또는 양수인 경우 해당 숫자를 반환")
    void inputOnlyPositiveOrZeroNumber() {
        int three = StringAddCalculator.input("3");
        int zero = StringAddCalculator.input("0");

        assertAll(
                () -> assertEquals(3, three),
                () -> assertEquals(0, zero)
        );
    }

    @ParameterizedTest(name = "입력값에 음수 및 문자열({0})이 들어오면 RuntimeException을 발생")
    @ValueSource(strings = {"-5", "abc"})
    void inputNegativeNumberAndCharacter(String invalidNumber) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> StringAddCalculator.input(invalidNumber))
                .withMessage(StringAddCalculator.INVALID_NUMBER_FORMAT_MESSAGE);
    }

    @Test
    @DisplayName("입력값에 Integer의 범위를 벗어나는 수가 들어오면 RuntimeException을 발생")
    void inputLongValue() {
        String longNumber = String.valueOf(Integer.MAX_VALUE + 1L);

        assertThatThrownBy(() -> StringAddCalculator.input(longNumber))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(StringAddCalculator.INVALID_NUMBER_RANGE_MESSAGE);
    }
}
