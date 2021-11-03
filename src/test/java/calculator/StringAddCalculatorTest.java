package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {

    @DisplayName("빈 문자열이나 null 입력시 0을 반환한다")
    @ParameterizedTest
    @NullAndEmptySource
    void givenNullOrEmptyString(String input) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(0);
    }

    @DisplayName("숫자 하나 입력시 해당 숫자를 반환한다")
    @ParameterizedTest
    @ValueSource(strings = {"1", "3", "5", "7"})
    void givenOneNumber(String input) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(Integer.parseInt(input));
    }

    @DisplayName("숫자 두개를 컴마로 구분시 두 숫자의 합을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1,2:3", "1,5:6", "3,4:7", "8,7:15", "10,16:26"}, delimiter = ':')
    void givenTwoNumbersUsingComma(String input, int result) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(result);
    }

    @DisplayName("숫자 두개를 콜론으로 구분시 두 숫자의 합을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1:2;3", "1:5;6", "3:4;7", "8:7;15", "10:16;26"}, delimiter = ';')
    void givenTwoNumbersUsingColon(String input, int result) {
        assertThat(StringAddCalculator.splitAndSum(input)).isEqualTo(result);
    }

}