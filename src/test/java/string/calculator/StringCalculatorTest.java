package string.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.assertThat;

class StringCalculatorTest {
    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("입력 문자열이 null 또는 \"\"(empty string) 이면 결과값은 0 이다.")
    void zeroIfNullOrEmpty(String input) {
        final StringCalculator stringCalculator = new StringCalculator(input);
        final int result = stringCalculator.calculate();
        assertThat(result).isEqualTo(0);
    }
}
