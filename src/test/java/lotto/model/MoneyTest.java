package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @Test
    void isValueObject() {
        final Money money = new Money(3_000);
        assertThat(money).isEqualTo(new Money(3_000));
        assertThat(money).isNotEqualTo(new Money(4_000));
    }

    @Test
    void divideBy() {
        final Money totalMoney = new Money(14_000);
        final Money price = new Money(1_000);
        assertThat(totalMoney.divideBy(price)).isEqualTo(14);
    }

    @Test
    void isZero() {
        Money money = new Money(0);
        assertThat(money.isZero()).isTrue();
        money = new Money(2_000);
        assertThat(money.isZero()).isFalse();
    }
}
