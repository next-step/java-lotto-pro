package lotto.model;

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
        assertThat(store.giveLotto(14000).allGames().size()).isEqualTo(14);
    }

}
