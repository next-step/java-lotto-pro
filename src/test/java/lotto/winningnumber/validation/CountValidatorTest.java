package lotto.winningnumber.validation;

import static lotto.winningnumber.validation.WinningNumberValidator.ERROR_COUNT_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CountValidatorTest {

    WinningNumberValidator validator = new CountValidator();

    @Test
    @DisplayName("당첨번호의 갯수가 6개면 통과 아니면 EX 발생")
    void count() {
        assertThatNoException().isThrownBy(() -> validator.validate(Arrays.asList("1", "2", "3", "4", "5", "6")));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(Arrays.asList("1", "2", "3", "4", "5")))
                .withMessageContaining(ERROR_COUNT_MESSAGE);
    }
}
