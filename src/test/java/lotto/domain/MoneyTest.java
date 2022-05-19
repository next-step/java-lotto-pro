package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @ParameterizedTest
    @ValueSource(ints = {100, 1000, 10000, 100000})
    void 금액_입력(final int number) {
        assertThatCode(() -> new Money(number)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {100001, 0, -100, -200, -300, -123456789})
    void 금액_입력_예외(final int number) {
        assertThatThrownBy(() -> new Money(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}