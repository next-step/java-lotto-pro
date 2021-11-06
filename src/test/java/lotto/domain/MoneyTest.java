package lotto.domain;

import lotto.exception.NegativeMoneyException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MoneyTest {

    @Test
    void NotEnoughMoneyTest() {
        assertThatThrownBy(() -> new Money(-1))
                .isInstanceOf(NegativeMoneyException.class);
    }

    @Test
    void getTest() {
        Money money = new Money(10000);

        assertThat(money.get()).isEqualTo(10000);
    }
}