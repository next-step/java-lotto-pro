package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.exception.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 가게 테스트")
public class LottoShopTest {

    @DisplayName("천원단위로 로또를 구매하면 천원단위의 갯수만큼 로또가 구매되어야 한다")
    @ParameterizedTest
    @CsvSource(value = {"2000:2", "5000:5", "13000:13", "50000:50"}, delimiter = ':')
    void lotto_shop_test(int price, int count) {
        Lottos lottos = LottoShop.sale(price);
        assertThat(lottos.getLottos().size()).isEqualTo(count);
    }

    @DisplayName("로또 구매금액이 로또 금액보다 낮으면 예외가 발생해야 한다")
    @ParameterizedTest
    @ValueSource(ints = {0, 150, 300, 800, -2500})
    void lotto_shop_exception_test(int price) {
        assertThatThrownBy(() -> {
            LottoShop.sale(price);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.LESS_THAN_LOTTO_PRICE.getMessage());
    }

    @DisplayName("로또 구매금액이 로또 금액단위가 아니면 예외가 발생해야 한다")
    @ParameterizedTest
    @ValueSource(ints = {3500, 2222, 125400, 5050})
    void lotto_shop_exception_test2(int price) {
        assertThatThrownBy(() -> {
            LottoShop.sale(price);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.NOT_MATCHED_UNIT_PRICE.getMessage());
    }
}
