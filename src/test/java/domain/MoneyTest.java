package domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @Test
    void 돈_쓰기() {
        Money money = new Money(1000);
        assertThat(money.spend(1000)).isEqualTo(new Money(0));
    }
}
