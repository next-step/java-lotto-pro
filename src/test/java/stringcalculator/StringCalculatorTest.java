package stringcalculator;

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
    void calculate(String input, int expected) {
        int result = stringCalculator.calculate(input);
        assertEquals(expected, result);
    }

    @DisplayName("커스텀 구분자를 사용하여 계산한다.")
    @Test
    public void splitByCustomDelimiter() {
        int result = stringCalculator.calculate("//;\n1;2;3");
        assertEquals(6, result);
    }
}