package calculator;

import exception.ExceptionMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName("숫자(양수) 형식이 아닌 string 값을 인자로 받을 경우 RuntimeException이 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"-1", "a"})
    void create(String input) {
        // when and then
        assertThatThrownBy(() -> new Number(input))
                .isInstanceOf(RuntimeException.class)
                .hasMessage(ExceptionMessage.NOT_POSITIVE_NUMBER.message());
    }
}
