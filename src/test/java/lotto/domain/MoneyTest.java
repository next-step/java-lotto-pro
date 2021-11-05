package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class MoneyTest {
    @ParameterizedTest
    @ValueSource(longs = {1000L, 2000L, 1L})
    void testMoney(long amount) {
        Money money = Money.of(amount);
        assertThat(money.longValue()).isEqualTo(amount);
    }

    @ParameterizedTest
    @ValueSource(longs = {1000L, 2000L, 1L})
    void testEqual(long amount) {
        assertThat(Money.of(amount)).isEqualTo(Money.of(amount));
    }

    @Test
    void tetDivide() {
        assertThat(Money.of(100).divide(Money.of(20)).longValue()).isEqualTo(Money.of(5).longValue());
    }

    @Test
    void testDoubleValue() {
        assertThat(Money.of(100).divide(Money.of(30)).doubleValue()).isEqualTo(3.33);
    }
}
