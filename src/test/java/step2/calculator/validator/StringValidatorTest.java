package step2.calculator.validator;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static step2.calculator.constants.ErrorMessage.NEGATIVE_NUMBER_INPUT_ERROR;
import static step2.calculator.constants.ErrorMessage.NON_NUMERIC_INPUT_ERROR;
import static step2.calculator.generator.RandomNumberGenerator.generateNegativeRandomNumber;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

/**
 * @author : choi-ys
 * @date : 2022/05/14 9:53 오후
 */
@DisplayName("Validator:StringValidator")
class StringValidatorTest {

    @Test
    @DisplayName("숫자 여부 유효성 검사")
    public void numericValidationTest() {
        // Given
        final String given = "a";

        // When
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> StringValidator.numericValidation(given))
            .withMessageMatching(NON_NUMERIC_INPUT_ERROR);

        // Then
    }

    @Test
    @DisplayName("양수 여부 유효성 검사")
    public void positiveNumberValidationTest() {
        // Given
        final String given = String.valueOf(generateNegativeRandomNumber());

        // When
        assertThatExceptionOfType(RuntimeException.class)
            .isThrownBy(() -> StringValidator.positiveNumberValidation(given))
            .withMessageMatching(NEGATIVE_NUMBER_INPUT_ERROR);
    }
}