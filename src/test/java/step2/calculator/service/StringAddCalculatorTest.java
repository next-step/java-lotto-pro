package step2.calculator.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static step2.calculator.constants.ErrorMessage.NON_NUMERIC_INPUT_ERROR;
import static step2.calculator.generator.RandomNumberGenerator.generateNegativeRandomNumber;
import static step2.calculator.generator.RandomNumberGenerator.generatePositiveRandomNumber;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author : choi-ys
 * @date : 2022/05/14 9:21 오후
 */
@DisplayName("Service:StringAddCalculator")
class StringAddCalculatorTest {

    @ParameterizedTest
    @MethodSource
    @DisplayName("빈값 혹은 null 문자열 입력 시 0 반환")
    public void returnZero_WhenNullOrEmptyString(final String given) {
        // When & Then
        assertThat(StringAddCalculator.splitAndSum(given)).isEqualTo(0);
    }

    private static Stream returnZero_WhenNullOrEmptyString() {
        final String nullString = null;
        return Stream.of(
            Arguments.of(""),
            Arguments.of(nullString)
        );
    }

    @Test
    @DisplayName("단일 숫자를 문자열로 입력 시 해당 숫자 반환 처리")
    public void returnAsItIsNumber_WhenSingleNumberString() {
        // Given
        final int expected = generatePositiveRandomNumber();
        final String given = String.valueOf(expected);

        // When & Then
        assertThat(StringAddCalculator.splitAndSum(given)).isEqualTo(expected);
    }

    @Test
    @DisplayName("입력된 문자열이 양수가 아닌 경우 예외 처리")
    public void throwRuntimeException_WhenSingleNumberStringIsNegativeNumber() {
        // Given
        final int expected = generateNegativeRandomNumber();
        final String given = String.valueOf(expected);

        // When & Then
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> StringAddCalculator.splitAndSum(given));
    }

    @Test
    @DisplayName("입력된 문자열이 숫자가 아닌 경우 예외 처리")
    public void throwRuntimeException_WhenNonNumericString() {
        // Given
        final String given = "a";

        // When & Then
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> StringAddCalculator.splitAndSum(given))
            .withMessageMatching(NON_NUMERIC_INPUT_ERROR);
    }
}
