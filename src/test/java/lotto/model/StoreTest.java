package lotto.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreTest {
    Store store;
    Cashier cashier = new Cashier(14000);

    @Test
    @DisplayName("받은 금액과 로또 개수 일치 검증")
    public void countLottos() {
        store = new Store(cashier.buyCount());
        assertThat(store.giveCount()).isEqualTo(14);
    }

    @Test
    @DisplayName("받은 금액과 로또 객체수 일치 검증")
    public void countClassLottos() {
        store = new Store(cashier.buyCount());
        assertThat(store.giveLotto().allGames().size()).isEqualTo(14);
    }

}
