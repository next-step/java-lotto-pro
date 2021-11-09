package lotto.domain;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
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

    @Test
    void testMinus() {
        assertThat(Money.of(100).minus(Money.of(30))).isEqualTo(Money.of(70));
    }

    @ParameterizedTest
    @CsvSource(value = {"1000:1001", "999:1000"}, delimiter = ':')
    void testIsLessThan(long amount1, long amount2) {
        assertThat(Money.of(amount1).isLessThan(Money.of(amount2))).isTrue();
    }

    @Test
    void isModResultZeroTrue() {
        assertThat(Money.of(5000).isModResultZero(Money.of(10))).isTrue();
    }

    @Test
    void isModResultZeroFalse() {
        assertThat(Money.of(5000).isModResultZero(Money.of(11))).isFalse();
    }

    @Test
    void testGetDividedIntValue() {
        assertThat(Money.of(100).getDividedIntValue(Money.of(10))).isEqualTo(10);
        assertThat(Money.of(100).getDividedIntValue(10)).isEqualTo(10);
    }
}
