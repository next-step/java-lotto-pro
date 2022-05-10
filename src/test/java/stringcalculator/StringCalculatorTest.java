package stringcalculator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class StringCalculatorTest {

    private StringCalculator stringCalculator = new StringCalculator();

    @CsvSource(value = {"1,2:3|6", "1,2|3", "1,2,3|6"}, delimiter = '|')
    @ParameterizedTest
    void calculate(String input, int expected) {
        int result = stringCalculator.calculate(input);
        assertEquals(expected, result);
    }
}