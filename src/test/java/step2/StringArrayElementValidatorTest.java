package step2;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step2.utils.StringArrayElementValidator;

public class StringArrayElementValidatorTest {

    @Test
    @DisplayName("구분자가 아닌 문자 입력시 RuntimeException을 발생한다.")
    public void notNumberValidatorAbnormal() {
        String[] sources = {"1", "bb", "a"};
        assertThatThrownBy(() -> StringArrayElementValidator.validateSplitResult(sources))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("숫자가 아닌 문자가 포함되어있습니다");
    }

    @Test
    @DisplayName("음수 입력시 RuntimeException을 발생한다.")
    public void positiveNumberValidatorAbnormal() {
        String[] sources = {"-1", "-2", "3"};
        assertThatThrownBy(() -> StringArrayElementValidator.validateSplitResult(sources))
            .isInstanceOf(RuntimeException.class)
            .hasMessage("음수가 포함되어 있습니다");

    }
}