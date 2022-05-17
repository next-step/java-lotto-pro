package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {
    @DisplayName("두 숫자를 더한다")
    @ParameterizedTest
    @CsvSource(value = {"3,4,7", "1,2,3"})
    void sum(String value1, String value2, String expected) {
        Number number1 = Number.from(value1);
        Number number2 = Number.from(value2);
        Number expectedNumber = Number.from(expected);
        assertThat(number1.add(number2)).isEqualTo(expectedNumber);
    }

    @DisplayName("숫자 0 생성")
    @Test
    void zero() {
        assertThat(Number.ZERO.getValue()).isZero();
    }

    @DisplayName("숫자 이외의 값을 전달하면 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"a", "#", "", "1-1"})
    void not_number(String notNumber) {
        assertThatThrownBy(() -> Number.from(notNumber))
                .isInstanceOf(RuntimeException.class);
    }
}
