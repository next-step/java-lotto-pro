package lotto.domain.purchase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class PurchaseAmountTest {

    @ParameterizedTest(name = "구입 금액으로 티켓 장수 계산: [{index}] {1}")
    @CsvSource(value = {"10000, 10", "50000, 50"})
    @DisplayName("구입 금액으로 티켓 장수를 계산한다.")
    void createPurchaseAmount(int money, int excepted) {
        //given
        PurchaseMoney purchaseMoney = new PurchaseMoney(money);

        //when
        PurchaseAmount purchaseAmount = new PurchaseAmount(purchaseMoney.getPurchaseAmount());

        //then
        assertThat(purchaseAmount.getAutoTicketAmount()).isEqualTo(excepted);
    }
}
