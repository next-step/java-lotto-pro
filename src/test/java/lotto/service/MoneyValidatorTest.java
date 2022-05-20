package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyValidatorTest {
    @ParameterizedTest
    @ValueSource(ints = {0, -1000, 900, 1900})
    @DisplayName("1000원 단위가 아니면 IllegalArgumentException을 발생시킨다")
    void when_amount_of_money_is_invalid_should_throw_IllegalArgumentException(final int money) {
        // when and then
        assertThatThrownBy(() -> MoneyValidator.validate(money))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
