package calculator.domain.target.validation;

import static calculator.domain.target.validation.CalculatorValidator.ERROR_NUMBER_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.assertj.core.api.Assertions.assertThatNoException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PositiveNumberValidatorTest {

    CalculatorValidator validator = new PositiveNumberValidator();

    @ParameterizedTest
    @ValueSource(strings = {"a", "-", "%"})
    void 숫자_아니면_EX(String target) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> validator.validate(target))
                .withMessageContaining(ERROR_NUMBER_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-3"})
    void 음수라면_EX(String target) {
        assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> validator.validate(target))
                .withMessageContaining(ERROR_NUMBER_MESSAGE);
    }

    @ParameterizedTest
    @DisplayName("양수(0포함)라면 통과")
    @ValueSource(strings = {"0", "1", "2"})
    void 양수라면_통과(String target) {
        assertThatNoException().isThrownBy(() -> validator.validate(target));
    }
}
