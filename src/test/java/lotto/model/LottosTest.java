package lotto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {

    @Test
    void createLottos() {
        assertThat(new Lottos(10000).getLottosSize()).isEqualTo(10);
    }

    @Test
    void createLottos_금액부족() {
        assertThatThrownBy(() -> new Lottos(999)).isInstanceOf(IllegalArgumentException.class);
    }
}
