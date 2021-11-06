package lotto.domain.purchase;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class PurchaseAmountTest {

    @ParameterizedTest(name = "수동 및 자동 티켓 장수 계산: [{index}] {0}원 수동 {1}장")
    @CsvSource(value = {"5000, 0, 5, 0", "10000, 3, 7, 3"})
    @DisplayName("수동 티켓 구입 장수 만큼 수동 티켓 장수를 가진다.")
    void createPurchaseAmount(int money, int manualAmount, int exceptedAuto, int exceptedManual) {
        //given
        PurchaseMoney purchaseMoney = new PurchaseMoney(money);

        //when
        PurchaseAmount purchaseAmount = purchaseMoney.getPurchaseAmount(manualAmount);

        //then
        assertThat(purchaseAmount.getAutoTicketAmount()).isEqualTo(exceptedAuto);
        assertThat(purchaseAmount.getManualTicketAmount()).isEqualTo(exceptedManual);
    }

    @Test
    @DisplayName("전체 티켓 장수 보다 수동 구매 장수가 많은 경우 예외가 발생한다.")
    void validation() {
        //given
        PurchaseMoney purchaseMoney = new PurchaseMoney(5000);
        int invalidManualAmount = 6;

        //when //then
        assertThatIllegalArgumentException()
                .isThrownBy(() -> purchaseMoney.getPurchaseAmount(invalidManualAmount));
    }
}
