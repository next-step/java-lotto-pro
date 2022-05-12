package calculator.validator;

import static calculator.constants.ErrorMessage.INVALID_NUMBER_ERROR_MESSAGE;
import static calculator.constants.ErrorMessage.NEGATIVE_NUMBER_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : choi-ys
 * @date : 2022/05/12 3:55 오후
 */
@DisplayName("Validator:String")
class StringValidatorTest {

    @Test
    @DisplayName("숫자가 아닌 입력 값 예외 처리")
    public void validateIsNonNumeric() {
        // Given
        final String given = "가나다";

        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> StringValidator.numberValidation(given))
            .withMessageContaining(INVALID_NUMBER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("음수를 입력하는 경우")
    public void validateIsNegative() {
        // Given
        final String given = "-1";

        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> StringValidator.positiveNumberValidation(given))
            .withMessageContaining(NEGATIVE_NUMBER_ERROR_MESSAGE);
    }
}