package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class QuantityTest {
    @DisplayName("수량은 0보다 커야 한다")
    @Test
    void minimum_test() {
        assertThatThrownBy(() -> new Quantity(-1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("수량은 0보다 작을 수 없습니다.");
    }
}
