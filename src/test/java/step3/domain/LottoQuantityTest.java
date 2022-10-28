package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoQuantityTest {

    @ParameterizedTest
    @CsvSource(value = {"1999:1", "2000:2"}, delimiter = ':')
    @DisplayName("입력된 금액에 따라 정확한 로또 수량이 반환되어야 한다")
    void of_calculate_quantity_by_amount(int amount, int expected) {
        LottoQuantity quantity = LottoQuantity.of(amount);

        assertThat(quantity.getQuantity()).isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"999", "0", "-1", "-100", "66"})
    @DisplayName("입력된 금액이 로또 가격보다 낮을 경우 에러가 발생해야 한다")
    void of_throw_exception_amount_less_than_lotto_price(int amount) {
        assertThatThrownBy(() -> LottoQuantity.of(amount))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
