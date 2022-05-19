package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.exception.ExceptionType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("로또 가게 테스트")
public class LottoShopTest {

    @DisplayName("로또를 수동으로 직접 구매하면 구매되어야 한다")
    @Test
    void lotto_shop_test() {
        List<String> 수동_번호 = Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7");
        Price price = new Price(3000);

        Lottos lottos = LottoShop.buyManualLottos(수동_번호, price);
        assertThat(lottos.size()).isEqualTo(2);
    }

    @DisplayName("로또를 수동으로 직접 구매하는데 금액이 부족하면 예외가 발생한다")
    @Test
    void lotto_shop_test2() {
        List<String> 수동_번호 = Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7");
        Price price = new Price(1000);

        assertThatThrownBy(() -> {
            LottoShop.buyManualLottos(수동_번호, price);
        }).isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining(ExceptionType.IS_LACK_OF_PRICE.getMessage());
    }

    @DisplayName("천원단위로 로또를 자동으로 구매하면 천원단위의 갯수만큼 로또가 구매되어야 한다")
    @ParameterizedTest
    @CsvSource(value = {"2000:2", "5000:5", "13000:13", "50000:50"}, delimiter = ':')
    void lotto_shop_test3(int 금액, int count) {
        Price price = new Price(금액);

        Lottos lottos = LottoShop.buyAutoLottos(price);
        assertThat(lottos.size()).isEqualTo(count);
    }

    @DisplayName("수동으로 구매하고 남은 금액을 자동으로 전달하면 개수에 맞게 구매되어야 한다")
    @ParameterizedTest
    @CsvSource(value = {"2000:2", "5000:5", "13000:13", "50000:50"}, delimiter = ':')
    void lotto_shop_test4() {
        Price price = new Price(10000);
        List<String> 수동_번호 = Arrays.asList("1,2,3,4,5,6", "2,3,4,5,6,7", "3,4,5,6,7,8");

        Lottos 수동_로또 = LottoShop.buyManualLottos(수동_번호, price);
        assertThat(수동_로또.size()).isEqualTo(3);

        Lottos 자동_로또 = LottoShop.buyAutoLottos(price);
        assertThat(자동_로또.size()).isEqualTo(7);
    }
}
