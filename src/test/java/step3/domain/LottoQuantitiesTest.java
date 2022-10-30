package step3.domain;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class LottoQuantitiesTest {

    @ParameterizedTest
    @CsvSource(value = {"1999:1:0", "2000:2:0", "30000:20:10"}, delimiter = ':')
    @DisplayName("입력된 예산과 수동 구매 수량에 맞추어 자동 구매 수량이 정상적으로 반환되어야 한다")
    void of_calculate_auto_lotto_quantity_by_budget(int budget, int manualQuantity, int autoQuantity) {
        // given
        LottoQuantities lottoQuantities = LottoQuantities.of(budget, manualQuantity);

        // when
        int result = lottoQuantities.getAutoLottoQuantity();

        // then
        assertThat(result).isEqualTo(autoQuantity);
    }

    @ParameterizedTest
    @CsvSource(value = {"999,1", "0,1", "-1,1", "-100,1", "66,1"})
    @DisplayName("입력된 예산으로 수동 구매 수량을 구매할 수 없을 경우 에러가 반환되어야 한다")
    void of_throw_exception_amount_less_than_lotto_price(int budget, int manualQuantity) {
        assertThatThrownBy(() -> LottoQuantities.of(budget, manualQuantity))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"3999:3", "50000:30"}, delimiter = ':')
    @DisplayName("입력된 예산과 수동 구매 수량에 맞추어 수동 구매 수량이 정상적으로 반환되어야 한다")
    void of_calculate_manual_quantity_by_amount(int budget, int manualQuantity) {
        // given
        LottoQuantities lottoQuantities = LottoQuantities.of(budget, manualQuantity);

        // when
        int result = lottoQuantities.getManualLottoQuantity();

        // then
        assertThat(result).isEqualTo(manualQuantity);
    }
}