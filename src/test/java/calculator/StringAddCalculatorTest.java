package calculator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {

    @Test
    @DisplayName("입력값이 null이거나 빈 문자열일 경우 0을 반환")
    void inputNullOrBlank() {
        long blankString1 = StringAddCalculator.input("");
        long blankString2 = StringAddCalculator.input(" ");
        long nullString = StringAddCalculator.input(null);

        assertAll(
                () -> assertThat(blankString1).isZero(),
                () -> assertThat(blankString2).isZero(),
                () -> assertThat(nullString).isZero()
        );
    }

    @Test
    @DisplayName("입력값이 0 또는 양수인 경우 해당 숫자를 반환")
    void inputOnlyPositiveOrZeroNumber() {
        long three = StringAddCalculator.input("3");
        long zero = StringAddCalculator.input("0");

        assertAll(
                () -> assertEquals(3L, three),
                () -> assertThat(zero).isZero()
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

    @ParameterizedTest(name = "숫자({0})를 구분자를 포함해 입력 받았을 경우 숫자의 합({1})을 반환")
    @CsvSource(value = {"2,3|5", "3;6|9", "1;2,3|6"}, delimiter = '|')
    void inputTwoNumberContainDelimiter(String inputNumber, long expected) {
        long result = StringAddCalculator.input(inputNumber);

        assertEquals(expected, result);
    }

    @Test
    @DisplayName("극값(2147483647)을 포함한 수를 입력 받았을 경우 결과가 정상적으로 반환")
    void inputTwoNumberContainLocalExtremumNumber() {
        long result = StringAddCalculator.input("2147483647;3");

        assertEquals(2147483650L, result);
    }

    @ParameterizedTest(name = "커스텀 구분자({0})가 포함된 수를 입력 받았을 경우 결과({1})가 정상적으로 반환")
    @MethodSource("parameterCustomDelimiter")
    void inputNumbersContainCustomDelimiter(String inputNumber, long expected) {
        long result = StringAddCalculator.input(inputNumber);

        assertEquals(expected, result);
    }

    public static Stream<Arguments> parameterCustomDelimiter() {
        return Stream.of(
                Arguments.of("//;\n1;2;3", 6L),
                Arguments.of("//-\n5-8", 13L)
        );
    }

    @ParameterizedTest(name = "올바르지 않는 숫자 및 문자({0})를 포함한 수가 들어오면 RuntimeException을 발생")
    @MethodSource("parameterInvalidNumber")
    void inputNumbersContainInvalidNumber(String invalidNumber) {
        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> StringAddCalculator.input(invalidNumber))
                .withMessage(StringAddCalculator.INVALID_NUMBER_FORMAT_MESSAGE);
    }

    public static Stream<Arguments> parameterInvalidNumber() {
        return Stream.of(
                Arguments.of("1;5,-8"),
                Arguments.of("//;\n1;-9;3"),
                Arguments.of("1;5;A")
        );
    }
}
