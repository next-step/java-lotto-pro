package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    @DisplayName("숫자 형식이 아닌 string 값을 인자로 받을 경우 RuntimeException이 발생한다")
    @Test
    void create() {
        // when and then
        assertThatThrownBy(() -> new Number("a"))
                .isInstanceOf(RuntimeException.class);
    }
}
