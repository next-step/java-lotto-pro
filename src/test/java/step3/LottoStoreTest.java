package step3;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {

    @Test
    @DisplayName("로또 구입")
    public void testPurchase() {
        LottoStore store = new LottoStore();
        Lottos lottos = store.purchase(LottoStore.PRICE_PER_LOTTO);
        assertThat(lottos).isNotNull();
    }

    @Test
    @DisplayName("로또 구입시 금액 부족 Exception 발생")
    public void testPurchaseError() {
        assertThatThrownBy(() -> {
            new LottoStore().purchase(0);
        })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("You don't have enough money.");
    }
}
