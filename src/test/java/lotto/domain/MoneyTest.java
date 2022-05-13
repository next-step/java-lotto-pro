package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @Test
    void 유효한_돈() {
        Money money = new Money(1000);
        assertThat(money.getMoney()).isEqualTo(1000);
        money = new Money("1000");
        assertThat(money.getMoney()).isEqualTo(1000);
    }

    @Test
    void 유효하지_않은_돈() {
        assertThatThrownBy(() -> {
            new Money(-10);
        }).isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> {
            new Money("-10");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
