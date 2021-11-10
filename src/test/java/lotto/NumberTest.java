package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 45})
    @DisplayName("1~45 사이의 숫자로 로또 번호를 생성할 수 있다.")
    void create(final int value) {
        assertDoesNotThrow(() -> new Number(value));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또 번호는 1보다 작거나 45보다 클 수 없다.")
    void create_invalidRange(final int value) {
        assertThatThrownBy(() -> new Number(value))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
