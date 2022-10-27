package string.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @ValueSource(strings = {"1:2:3", "1,2,3"})
    @DisplayName("입력 문자열이 기본 구분자를 사용하는 경우")
    void splitInputWithDefaultDelimiter(String input) {
        final StringCalculator stringCalculator = new StringCalculator(input);
        final String[] tokens = stringCalculator.splitInput();
        assertThat(tokens).contains("1", "2", "3");
    }

    @ParameterizedTest
    @ValueSource(strings = {"//?\\n1?2?3", "//.\\n1.2.3", "//~\\n1~2~3", "//|\\n1|2|3"})
    @DisplayName("입력 문자열이 커스텀 구분자를 사용하는 경우")
    void splitInputWithCustomDelimiter(String input) {
        final StringCalculator stringCalculator = new StringCalculator(input);
        final String[] tokens = stringCalculator.splitInput();
        assertThat(tokens).contains("1", "2", "3");
    }
}
