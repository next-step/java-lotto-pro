package calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class StringAddCalculatorTest {
    @DisplayName("빈 문자열 또는 null을 입력할 경우 0을 반환한다")
    @ParameterizedTest
    @NullAndEmptySource
    void calculate_empty_null(String string) {
        assertThat(StringAddCalculator.splitAndSum(string)).isZero();
    }

    @DisplayName("숫자 하나를 입력할 경우 해당 숫자를 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"0,0", "1,1"})
    void calculate_1_value(String given, int expected) {
        assertThat(StringAddCalculator.splitAndSum(given)).isEqualTo(expected);
    }

    @DisplayName("기본 구분자(, 또는 :)로 구분된 숫자들을 입력할 경우 숫자들의 합을 반환한다")
    @ParameterizedTest
    @CsvSource(value = {"1:2,3=6", "4,5:6=15"}, delimiter = '=')
    void calculate_values(String given, int expected) {
        assertThat(StringAddCalculator.splitAndSum(given)).isEqualTo(expected);
    }

    @DisplayName("커스텀 구분자를 지정하면 해당 구분자로 구분된 숫자들의 합을 반환한다")
    @Test
    void calculate_values_by_custom() {
        String given = "//;\n1;2;3";
        int expected = 6;
        assertThat(StringAddCalculator.splitAndSum(given)).isEqualTo(expected);
    }

    @DisplayName("숫자 이외의 값 또는 음수를 입력할 경우 RuntimeException이 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "#", "-1"})
    void invalid_number(String invalidString) {
        Assertions.assertThatThrownBy(() -> StringAddCalculator.splitAndSum(invalidString))
                .isInstanceOf(RuntimeException.class);
    }
}
