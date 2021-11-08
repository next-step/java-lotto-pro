package calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

public class DelimitersTest {
    @ParameterizedTest(name = "{0} 구분자 입력 테스트")
    @CsvSource(value = {",: 1,2,3", ",:b 1b2b3b"}, delimiterString = " ")
    void inputDelimiterTest(String delimitersInput, String numbersInput) {
        // given
        Delimiters delimiters = new Delimiters(delimitersInput);
        // when
        String[] numbersText = delimiters.splitTextByDelimiter(numbersInput);
        Numbers numbers = new Numbers(numbersText);
        // then
        assertThat(numbers).isEqualTo(new Numbers(Arrays.asList(new Number("1"), new Number("2"), new Number("3"))));
    }
}
