package lotto.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {1000, 10000, 100000})
    void inputMoney(final int input) {
        assertThatCode(() -> new Money(input)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 500, 101000})
    void exception(final int input) {
        assertThatThrownBy(() -> new Money(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}