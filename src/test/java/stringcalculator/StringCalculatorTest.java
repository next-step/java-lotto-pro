package stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @NullAndEmptySource
    @ParameterizedTest
    void nullOrEmptyReturnZero(String input) {
        int result = stringCalculator.calculate(input);
        assertEquals(0, result);
    }

    @CsvSource(value = {"1,2:3|6", "1,2|3", "1,2,3|6"}, delimiter = '|')
    @ParameterizedTest
    void calculate(String input, int expected) {
        int result = stringCalculator.calculate(input);
        assertEquals(expected, result);
    }
}