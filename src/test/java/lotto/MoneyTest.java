package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {-5, -100, -2345, -5000})
    @DisplayName("음수 금액 투입 시 IllegalArgumentException 발생")
    void 음수_금액_투입(int data) {
        assertThatThrownBy(() -> new Money(data)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(ints = {15, 1500, 5300, 84360})
    @DisplayName("로또 가격으로 나누어지지 않는 금액 투입 시 IllegalArgumentException 발생")
    void 나누어지지_않는_금액_투입(int data) {
        assertThatThrownBy(() -> new Money(data)).isInstanceOf(IllegalArgumentException.class);
    }
}
