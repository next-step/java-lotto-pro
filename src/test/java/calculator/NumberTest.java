package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("숫자")
class NumberTest {

    @DisplayName("문자일 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"s"})
    void not_number(String number) {
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(NumberFormatException.class);
    }

    @DisplayName("음수일 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"-1"})
    void negative(String number) {
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("양수만 입력 가능합니다.");
    }

    @DisplayName("숫자 클래스 생성")
    @ParameterizedTest
    @ValueSource(strings = {"0", "1"})
    void constructor(String number) {
        assertThatNoException().isThrownBy(() -> new Number(number));
    }
}
