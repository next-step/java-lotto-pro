package calculator.validator;

import static calculator.constants.ErrorMessage.INVALID_NUMBER_ERROR_MESSAGE;
import static calculator.constants.ErrorMessage.NEGATIVE_NUMBER_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : choi-ys
 * @date : 2022/05/12 3:55 오후
 */
@DisplayName("Validator:String")
class StringValidatorTest {
    public static final String nonNumericString = "a";
    public static final String negativeNumberString = "-1";

    @Test
    @DisplayName("숫자 여부 판별")
    public void isNumberTest() {
        // When & Then
        assertThat(StringValidator.isNumber(nonNumericString)).isFalse();
    }

    @Test
    @DisplayName("양수 여부 판별")
    public void isValidNumberTest() {
        // When & Then
        assertThat(StringValidator.isPositiveNumber(negativeNumberString)).isFalse();
    }

    @Test
    @DisplayName("숫자가 아닌 입력 값 예외 처리")
    public void validateIsNonNumeric() {
        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> StringValidator.numberValidation(nonNumericString))
            .withMessageContaining(INVALID_NUMBER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("음수를 입력하는 경우")
    public void validateIsNegative() {
        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> StringValidator.positiveNumberValidation(negativeNumberString))
            .withMessageContaining(NEGATIVE_NUMBER_ERROR_MESSAGE);
    }
}