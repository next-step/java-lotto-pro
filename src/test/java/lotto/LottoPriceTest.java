package lotto;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoPriceTest {

    @Test
    void 로또금액을_입력받으면_구매_가능한_로또_개수를_반환한다() {
        // when
        int count = LottoPrice.purchase(5000);
        // then
        assertThat(count).isEqualTo(5);
    }

    @ValueSource(ints = {-1000, 0, 999})
    @ParameterizedTest
    void 입력받은_금액이_1000원_미만이면_예외가_발생한다(int money) {
        // when and then
        assertThatThrownBy(() ->
            LottoPrice.purchase(money)
        ).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 구매금액을_계산한다() {
        // when
        int price = LottoPrice.calculatePurchaseAmount(10);
        // then
        assertThat(price).isEqualTo(10000);
    }
}