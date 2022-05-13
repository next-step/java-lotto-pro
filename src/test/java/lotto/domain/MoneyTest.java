package lotto.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MoneyTest {

    @Test
    void create() {
        Money money = Money.from(1000);
        assertThat(money).isNotNull();
    }

}
