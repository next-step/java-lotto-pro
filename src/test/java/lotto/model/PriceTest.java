package lotto.model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PriceTest {

    @ParameterizedTest(name = "최소 금액 미만의 값을 입력하면 오류가 발생한다.")
    @ValueSource(strings = {"100", "-1000", "999"})
    void invalidRangeInputTest(String money) {
        // given & when & then
        assertThatIllegalArgumentException().isThrownBy(
                () -> Price.minimumPriceCheck(money));
    }

    @Test
    @DisplayName("Price 객체는 로또 한 장의 금액을 가진다")
    void priceTest() {
        // given & when
        int price = Price.lottoPrice();

        // then
        assertThat(price).isEqualTo(1000);
    }

}
