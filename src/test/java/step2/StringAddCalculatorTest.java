package step2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {
    private StringAddCalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new StringAddCalculator();
    }

    @Test
    @DisplayName("null은 0을 반환")
    public void Null_return_zero() {
        assertThat(calculator.splitAndSum(null)).isEqualTo(0);
    }

    @Test
    @DisplayName("공백은 0을 반환")
    public void Blank_return_zero() {
        assertThat(calculator.splitAndSum("")).isEqualTo(0);
    }

    @ParameterizedTest
    @CsvSource(value = {"0:0", "1:1", "2:2", "3:3", "4:4", "5:5", "6:6", "7:7", "8:8", "9:9"}, delimiter = ':')
    @DisplayName("숫자 하나는 숫자를 리턴")
    public void Single_number_return_number(String number, int expected) {
        assertThat(calculator.splitAndSum(number)).isEqualTo(expected);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "11", "123", "&", "*", "1234", "1a2a3a"})
    @DisplayName("단일 숫자가 아니라면 false를 리턴")
    public void Return_false_if_not_single_digit_number(String input) {
        assertThat(calculator.isSingleDigitNumber(input)).isFalse();
    }

    @Test
    public void splitAndSum_null_또는_빈문자() {
        int result = StringAddCalculator.splitAndSum(null);
        assertThat(result).isEqualTo(0);

        result = StringAddCalculator.splitAndSum("");
        assertThat(result).isEqualTo(0);
    }

    @Test
    public void splitAndSum_숫자하나() throws Exception {
        int result = StringAddCalculator.splitAndSum("1");
        assertThat(result).isEqualTo(1);
    }

    @Test
    public void splitAndSum_쉼표구분자() throws Exception {
        int result = StringAddCalculator.splitAndSum("1,2");
        assertThat(result).isEqualTo(3);
    }

}