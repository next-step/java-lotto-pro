package lotto.domain;

import lotto.exception.NegativeMoneyException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {

    @Test
    void NotEnoughMoneyTest() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(NegativeMoneyException.class);
    }
}