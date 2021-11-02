package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
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


}