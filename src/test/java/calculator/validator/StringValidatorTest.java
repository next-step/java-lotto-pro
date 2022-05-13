package calculator.validator;

import static calculator.constants.ErrorMessage.INVALID_NUMBER_ERROR_MESSAGE;
import static calculator.constants.ErrorMessage.NEGATIVE_NUMBER_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : choi-ys
 * @date : 2022/05/13 2:23 오후
 */
@DisplayName("Validator:String")
class StringValidatorTest {

    @Test
    @DisplayName("숫자가 아닌 입력값 예외 처리")
    public void numberValidationTest() {
        // Given
        final String given = "a";

        // When & Then
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> StringValidator.numberValidation(given))
            .withMessageMatching(INVALID_NUMBER_ERROR_MESSAGE);
    }

    @Test
    @DisplayName("음수 입력값 예외 처리")
    public void positiveNumberValidationTest() {
        // Given
        final String given = "-1";

        // When
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> StringValidator.positiveNumberValidation(given))
            .withMessageMatching(NEGATIVE_NUMBER_ERROR_MESSAGE);
    }
}
