package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @Test
    void 음수() {
        // given
        int money = -1;

        // when, then
        assertThatThrownBy(() -> new Money(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("금액은 0 이상이어야 합니다. (입력값: " + money + ")");
    }
}