package stringcalculator.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static stringcalculator.constants.ErrorMessageConstants.NON_POSITIVE_INTEGER_INPUT_ERROR;
import static stringcalculator.utils.PositiveIntegerChecker.isPositiveInteger;

import org.junit.jupiter.api.Test;

class PositiveIntegerCheckerTest {

    @Test
    void checkNegative() {
        String input = "-3";
        assertThatThrownBy(() -> isPositiveInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NON_POSITIVE_INTEGER_INPUT_ERROR);

    }

    @Test
    void checkNotInteger() {
        String input = "T";
        assertThatThrownBy(() -> isPositiveInteger(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(NON_POSITIVE_INTEGER_INPUT_ERROR);
    }
}
