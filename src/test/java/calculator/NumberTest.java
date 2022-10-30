package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DisplayName("숫자")
class NumberTest {

    @DisplayName("문자일 경우 예외 발생")
    @ParameterizedTest
    @ValueSource(strings = {"s"})
    void 문자_예외_발생(String number) {
        assertThatThrownBy(() -> new Number(number))
                .isInstanceOf(NumberFormatException.class);
    }
}
