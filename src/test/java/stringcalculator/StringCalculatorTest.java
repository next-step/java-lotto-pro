package stringcalculator;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @DisplayName("0 또는 0 인경우, 0을 반환한다.")
    @NullAndEmptySource
    @ParameterizedTest
    void nullOrEmptyReturnZero(String input) {
        int result = stringCalculator.calculate(input);
        assertEquals(0, result);
    }

    @DisplayName("기본 구분자를 사용하여 계산한다.")
    @CsvSource(value = {"1,2:3|6", "1,2|3", "1,2,3|6"}, delimiter = '|')
    @ParameterizedTest
    void calculateByDefaultDelimiter(String input, int expected) {
        int result = stringCalculator.calculate(input);
        assertEquals(expected, result);
    }

    @DisplayName("커스텀 구분자를 사용하여 계산한다.")
    @Test
    public void calculateByCustomDelimiter() {
        int result = stringCalculator.calculate("//;\n1;2;3");
        assertEquals(6, result);
    }

    @CsvSource(value = { "-1,2,3|숫자는 0보다 커야합니다.", "a,2,3|숫자로 변환할 수 없습니다."}, delimiter = '|')
    @ParameterizedTest
    public void calculate_fail(String input, String errorMessage) {
        assertThatIllegalArgumentException()
            .isThrownBy(() -> stringCalculator.calculate(input))
            .withMessage(errorMessage);
    }
}