package util;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {

    @ParameterizedTest
    @NullAndEmptySource
    @DisplayName("null 또는 빈문자가 입력될 경우 0이 반환되어야 한다")
    public void splitAndSum_return_zero_if_null_or_emptyString(String text) {

        // when
        int result = StringAddCalculator.splitAndSum(text);

        // then
        int expected = 0;
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "10", "100"})
    public void splitAndSum_return_original_number_if_single_number(String number) {

        // when
        int result = StringAddCalculator.splitAndSum(number);

        // then
        int expected = Integer.parseInt(number);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "1,3,5:9", "0,3,6:9", "5,5,5:15"}, delimiter = ':')
    public void splitAndSum_return_sum_if_text_split_by_comma(String text, int expected) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,2:3;6", "1,3,5:9;18", "0,3,6:9;18", "5,5,5:15;30"}, delimiter = ';')
    public void splitAndSum_return_sum_if_text_split_by_comma_and_colon(String text, int expected) {
        int result = StringAddCalculator.splitAndSum(text);
        assertThat(result).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1;2;3!6", "1,2:3;6!12", "1,3,5:9;18!36", "0,3,6:9;18!36", "5,5,5:15;30!60"}, delimiter = '!')
    @DisplayName("임의의 구분자를 지정하여 숫자의 합을 구할 수 있다")
    public void splitAndSum_return_sum_if_text_split_by_custom(String text, int expected) {
        String given = "//;\n" + text;
        int result = StringAddCalculator.splitAndSum(given);
        assertThat(result).isEqualTo(expected);
    }
}