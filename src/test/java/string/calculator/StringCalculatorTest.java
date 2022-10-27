package string.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    void zeroIfNullOrEmpty(String input) {
        final StringCalculator stringCalculator = new StringCalculator(input);
        final int result = stringCalculator.calculate();
        assertThat(result).isEqualTo(0);
    }
}
