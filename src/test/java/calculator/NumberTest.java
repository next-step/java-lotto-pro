package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {
    @DisplayName("빈 문자열이나 null 입력시 0을 반환한다")
    @ParameterizedTest
    @NullAndEmptySource
    void givenNullOrEmptyString(String input) {
        assertThat(new Number(input)).isEqualTo(new Number("0"));
    }

    @DisplayName("음수 입력시 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "-2", "-5"})
    void givenNegativeNumber(String input) {
        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("양수를 입력해야 합니다");
    }

}