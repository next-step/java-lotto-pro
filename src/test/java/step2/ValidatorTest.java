package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.validator.NotNumberValidator;
import step2.validator.Validator;

public class ValidatorTest {

    Validator notNumberValidator = new NotNumberValidator();

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
}
