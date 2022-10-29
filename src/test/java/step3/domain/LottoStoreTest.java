package step3.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoStoreTest {

    @Test
    @DisplayName("가진 금액만큼 로또 구입")
    public void testSell() {
        LottoStore store = new LottoStore();
        Money payment = Money.generate(1000);
        Lottos lottos = store.sell(payment);
        assertThat(lottos).isNotNull();
    }
}
