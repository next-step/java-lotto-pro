package lotto.winningnumber.validation;

import static lotto.winningnumber.validation.WinningNumberValidator.ERROR_WINNING_NUMBER_TYPE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumberTypeValidatorTest {

    WinningNumberValidator validator = new WinningNumberTypeValidator();

    @Test
    @DisplayName("당첨번호에 숫자가 아닌 값이 있으면 EX 발생")
    void number_type() {
        assertThatNoException().isThrownBy(() -> validator.validate(Arrays.asList("1", "2", "3", "4", "5", "6")));
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(Arrays.asList("1", "a", "3", "4", "5", "6")))
                .withMessageContaining(ERROR_WINNING_NUMBER_TYPE_MESSAGE);
    }
}
