package lotto;

import lotto.domain.Lottos;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class LottosTest {
    @Test
    @DisplayName("로또 n개 구입")
    void 로또_구입() {
        Lottos lottos = new Lottos();
        lottos.buyLottos(3);
        assertThat(lottos.size()).isEqualTo(3);
    }
}
