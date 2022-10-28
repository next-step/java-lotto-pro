package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {

    @Test
    @DisplayName("로또 구입")
    public void testPurchase() {
        LottoStore store = new LottoStore();
        Money payment = Money.generate(1000);
        Lottos lottos = store.purchase(payment);
        assertThat(lottos).isNotNull();
    }
}
