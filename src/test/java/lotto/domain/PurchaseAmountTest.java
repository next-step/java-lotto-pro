package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("PurchaseAmount 테스트")
class PurchaseAmountTest {

    @Test
    @DisplayName("구매 금액을 생성한다.")
    void create() {
        // given
        int amount = 10_000;

        // when
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);

        // then
        assertThat(purchaseAmount).isEqualTo(new PurchaseAmount(amount));
    }

    @Test
    @DisplayName("로또 단가보다 작은 금액으로 구매 금액을 생성하면 예외가 발생한다.")
    void createThrowException() {
        // given
        int amount = LottoCalculator.LOTTO_PRICE - 1;

        // when & then
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new PurchaseAmount(amount))
                .withMessageMatching(Message.PURCHASE_AMOUNT_MIN_ERROR.getMessageForTest());
    }
}
