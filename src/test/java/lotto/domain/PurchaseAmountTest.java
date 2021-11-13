package lotto.domain;

import lotto.common.Messages;
import lotto.exception.LottoException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

class PurchaseAmountTest {

    @DisplayName("PurchaseAmount 인스턴스 생성 성공 테스트")
    @Test
    void instantiate_success() {
        // given
        int amount = Lotto.PRICE;

        // when
        PurchaseAmount purchaseAmount = new PurchaseAmount(amount);

        // then
        assertThat(purchaseAmount).isInstanceOf(PurchaseAmount.class);
    }

    @DisplayName("PurchaseAmount 인스턴스 생성 실패 테스트")
    @Test
    void instantiate_failure() {
        // given
        int amount = Lotto.PRICE - 1;

        // when & then
        assertThatExceptionOfType(LottoException.class)
                .isThrownBy(() -> new PurchaseAmount(amount))
                .withMessage(Messages.PURCHASE_AMOUNT_LESS_THAN_LOTTO_PRICE);
    }

    @DisplayName("equalsAndHashCode 테스트")
    @Test
    void equalsAndHashCode() {
        // given
        int amount = Lotto.PRICE;

        // when
        PurchaseAmount purchaseAmount1 = new PurchaseAmount(amount);
        PurchaseAmount purchaseAmount2 = new PurchaseAmount(amount);

        // then
        assertThat(purchaseAmount1).isEqualTo(purchaseAmount2);
        assertThat(purchaseAmount1.hashCode()).hasSameHashCodeAs(purchaseAmount2.hashCode());
    }

    @DisplayName("구매 가능한 로또 개수 테스트")
    @Test
    void getPurchasableLottoCount() {
        // given
        Map<Integer, Integer> map = new HashMap<Integer, Integer>() {{
            put(Lotto.PRICE, 1);
            put(Lotto.PRICE + 100, 1);
            put(Lotto.PRICE * 10, 10);
        }};

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            // when
            PurchaseAmount purchaseAmount = new PurchaseAmount(entry.getKey());
            int count = purchaseAmount.getPurchasableLottoCount();

            // then
            assertThat(count).isEqualTo(entry.getValue());
        }
    }
}
