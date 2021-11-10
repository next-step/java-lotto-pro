package lotto.model;

import static lotto.model.Number.*;
import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 46})
    @DisplayName("로또의 숫자가 1~45 사이의 수가 아닐 경우 예외 발생")
    void 객체_생성_시_유효성_검사(int input) {
        assertThatIllegalArgumentException().isThrownBy(() ->
            Number.of(input)
        ).withMessageContaining(NUMBER_RANGE_ERR_MSG);
    }

    @Test
    void 동일성_검사() {
        assertThat(Number.of(1) == Number.of(1)).isTrue();
    }

    @Test
    @DisplayName("동등성 검사")
    void equals() {
        assertThat(Number.of(1)).isEqualTo(Number.of(1));
    }

    @Test
    @DisplayName("Comparable를 구현한 Number객체가 적절히 동작하는지 테스트")
    void compareTo() {
        assertThat(Number.of(2)).isGreaterThan(Number.of(1));
    }
}
