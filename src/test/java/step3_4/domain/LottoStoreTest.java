package step3_4.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    @DisplayName("로또 구입시 금액 부족 Exception 발생")
    public void testValidate() {
        LottoStore store = new LottoStore();
        Money payment = Money.generate(0);
        assertThatThrownBy(() -> {
            Lottos lottos = store.sell(payment);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("You don't have enough money.");
    }
}
