package lotto.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ManualAmountValidatorTest {
    @ParameterizedTest
    @ValueSource(ints = {-1, 11})
    @DisplayName("수동 구매 수량이 구매 가능 수량보다 크거나 0보다 작으면 IllegalArgumentException을 발생시킨다")
    void manual_amount_should_be_less_than_purchasable_amount_and_greater_than_zero(final int manualAmount) {
        // when and then
        assertThatThrownBy(() -> ManualAmountValidator.validate(manualAmount, 10))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
