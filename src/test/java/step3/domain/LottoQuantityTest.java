package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoQuantityTest {

    @ParameterizedTest
    @CsvSource(value = {"999:0", "1999:1", "2000:2"}, delimiter = ':')
    @DisplayName("입력된 금액에 따라 정확한 로또 수량이 반환되어야 한다")
    void of_calculate_quantity_by_amount(int amount, int expected) {
        LottoQuantity quantity = LottoQuantity.of(amount);

        assertThat(quantity.getQuantity()).isEqualTo(expected);
    }
}