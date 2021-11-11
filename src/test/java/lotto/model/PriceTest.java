package lotto.model;

import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.math.BigInteger;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PriceTest {

    @DisplayName("금액을 나눠서 로또를 몇개 사는지 계산하는 기능")
    @Test
    void divisionPrice() {
        assertThat(Price.numberPurchases(14000)).isEqualTo(14);
    }

    @DisplayName("로또를 산 갯수만큼 금액나오는 기능 검증")
    @Test
    void purchaseFromLottoCount() {
        BigInteger purchase = Price.totalPurchase(2);

        assertThat(purchase.toString()).isEqualTo("2000");
    }

    @DisplayName("로또 금액보다 작을때 에러 검증")
    @Test
    void validPurchasesTest() {
        assertThatThrownBy(() -> {
            Price.numberPurchases(-100);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LACK_OF_MONEY);

        assertThatThrownBy(() -> {
            Price.numberPurchases(0);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LACK_OF_MONEY);

        assertThatThrownBy(() -> {
            Price.numberPurchases(100);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.LACK_OF_MONEY);
    }
}
