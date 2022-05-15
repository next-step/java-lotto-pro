package calculator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberTest {
    @Test
    @DisplayName("입력된 문자는 양수이어야 한다.")
    void negative_test() {
        assertThatThrownBy(() -> {
            Number number = new Number("-2");
        }).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    @DisplayName("입력된 문자는 숫자형식이어야 한다.")
    void format_test() {
        assertThatThrownBy(() -> {
            Number number = new Number("A");
        }).isInstanceOf(IllegalArgumentException.class);

    }
}
