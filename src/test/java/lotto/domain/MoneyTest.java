package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @Test
    void 유효한_돈() {
        new Money(1000);
        new Money("1000");
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