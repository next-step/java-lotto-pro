package Lotto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottosTest {
    @Test
    void 금액1000원_로또1장_생성() {
        Lottos lottos = new Lottos(1000);
        assertThat(lottos.getLottos().size()).isEqualTo(1);
        assertThat(lottos.getPurchaseCount().getCount()).isEqualTo(1);
    }

    @Test
    void 금액10000원_로또10장_생성() {
        Lottos lottos = new Lottos(10000);
        assertThat(lottos.getLottos().size()).isEqualTo(10);
        assertThat(lottos.getPurchaseCount().getCount()).isEqualTo(10);
    }

    @Test
    void 금액1000원이하_IllegalArgumentException_에러() {
        assertThatThrownBy(() -> new Lottos(500))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
