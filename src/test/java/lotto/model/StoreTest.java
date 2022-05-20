package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreTest {
    Store store;
    Cashier cashier;

    @Test
    @DisplayName("받은 금액 만큼 로또 반환")
    public void prepareLottos() {
        cashier = new Cashier(14000);
        store = new Store(cashier.buyCount());
        assertThat(store.giveCount()).isEqualTo(14);
    }

}
