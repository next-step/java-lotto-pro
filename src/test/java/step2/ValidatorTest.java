package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.validator.NotNumberValidator;
import step2.validator.PositiveNumberValidator;
import step2.validator.Validator;

public class ValidatorTest {

    Validator notNumberValidator = new NotNumberValidator();
    Validator positiveNumberValidator = new PositiveNumberValidator();

    @Test
    @DisplayName("숫자 정상 입력")
    public void notNumberValidatorNormal() {
        String[] strings = {"1", "2", "3"};
        assertThat(notNumberValidator.validate(strings)).isTrue();
    }

    @Test
    @DisplayName("숫자 비정상 입력")
    public void notNumberValidatorAbnormal() {
        String[] strings = {"1", "bb", "a"};
        assertThat(notNumberValidator.validate(strings)).isFalse();
    }

    @Test
    @DisplayName("정상 입력시 true를반환한다.")
    public void positiveNumberValidatorNormal() {
        String[] strings = {"1", "2", "3"};
        assertThat(positiveNumberValidator.validate(strings)).isTrue();
    }

    @Test
    @DisplayName("음수 입력시 true를반환한다.")
    public void positiveNumberValidatorAbnormal() {
        String[] strings = {"-1", "-2", "3"};
        assertThat(positiveNumberValidator.validate(strings)).isFalse();
    }
}