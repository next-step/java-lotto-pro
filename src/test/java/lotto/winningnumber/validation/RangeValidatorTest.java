package lotto.winningnumber.validation;

import static lotto.winningnumber.validation.WinningNumberValidator.ERROR_RANGE_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.assertj.core.api.Assertions.assertThatNoException;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RangeValidatorTest {

    WinningNumberValidator validator = new RangeValidator();

    @ParameterizedTest
    @DisplayName("1~45 사이 값이 아니면 EX 발생")
    @ValueSource(strings = {"46", "0", "-1"})
    void range_ex(String ex) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> validator.validate(Arrays.asList("1", "2", "3", "4", "5", ex)))
                .withMessageContaining(ERROR_RANGE_MESSAGE);
    }

    @Test
    @DisplayName("1~45 사이 값이면 통과")
    void range_success() {
        assertThatNoException().isThrownBy(() -> validator.validate(Arrays.asList("1", "2", "3", "4", "5", "45")));

    }
}
