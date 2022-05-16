package lotto.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static lotto.domain.LottoConstant.LOTTO_PRICE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MoneyTest {
    @ParameterizedTest
    @ValueSource(longs = { LOTTO_PRICE, 2 * LOTTO_PRICE, 100 * LOTTO_PRICE })
    void 구매_가능한_로또_개수(long price) {
        Money money = new Money(price);
        assertThat(money.getAvailableLottosForPurchase()).isEqualTo(price / LOTTO_PRICE);
    }

    @ParameterizedTest
    @ValueSource(longs = { -1 * LOTTO_PRICE, LOTTO_PRICE / 2, LOTTO_PRICE - 1 })
    void 로또_구매_불가한_가격(long price) {
        assertThatThrownBy(() -> {
            new Money(price);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
