package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    private static final String EXCEPTION_MESSAGE_PREFIX = "[ERROR]";

    @ParameterizedTest
    @ValueSource(ints = {-1, -5, -10})
    void invalidAmount(final int amount) {
        assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Money.amountOf(amount))
            .withMessageContaining(EXCEPTION_MESSAGE_PREFIX);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    void validAmount(final int amount) {
        assertThatCode(() -> Money.amountOf(amount)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource(value = {"0:1", "1:2", "5:10"}, delimiter = ':')
    void isLessThan_differentAmount(final int smallAmount, final int amount) {
        assertThat(Money.amountOf(smallAmount).isLessThan(Money.amountOf(amount))).isTrue();
        assertThat(Money.amountOf(amount).isLessThan(Money.amountOf(smallAmount))).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 5, 10})
    void isLessThan_sameAmount(final int amount) {
        assertThat(Money.amountOf(amount).isLessThan(Money.amountOf(amount))).isFalse();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void divide_self(final int amount) {
        assertThat(Money.amountOf(amount).divide(Money.amountOf(amount)))
            .isEqualTo(Money.ONE);
    }

    @ParameterizedTest
    @CsvSource(value = {"1:2:0", "2:1:2", "4:2:2", "2:4:0", "3:5:0", "5:3:1",
        "100:10:10", "10:100:0"}, delimiter = ':')
    void divide_nonZero(final int amount1, final int amount2, final int expected) {
        assertThat(Money.amountOf(amount1).divide(Money.amountOf(amount2)))
            .isEqualTo(Money.amountOf(expected));
    }

}