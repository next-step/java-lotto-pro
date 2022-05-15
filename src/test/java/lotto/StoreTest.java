package lotto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class StoreTest {
    Store store;

    @BeforeEach
    public void setup() {
        store = new Store(1000);
    }

    @Test
    @DisplayName("받은 금액 만큼 로또 반환")
    public void prepareLottos() {
        store.receiveAmount(14000);
        assertThat(store.giveLotto().allGames().size()).isEqualTo(14);
    }

}
