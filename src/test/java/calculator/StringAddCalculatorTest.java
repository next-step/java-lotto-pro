package calculator;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

public class StringAddCalculatorTest {

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2|true", "1:2|true", "1;2|false"}, delimiter = '|')
    public void 기본_구분자를_가진_문자(String input, boolean expected) {
        boolean actualResult = StringAddCalculator.hasDelimiter(input);
        assertEquals(expected, actualResult);
    }

    @Test
    public void 커스텀_구분자를_가진_문자() {
        String hasCorrectDelimiter = "//;\n1;2;3|true";
        String hasIncorrectDelimiter = "/\n1;2;3|false";
        assertTrue(StringAddCalculator.hasDelimiter(hasCorrectDelimiter));
        assertFalse(StringAddCalculator.hasDelimiter(hasIncorrectDelimiter));
    }


}
