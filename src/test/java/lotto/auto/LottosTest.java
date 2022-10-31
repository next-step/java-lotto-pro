package lotto.auto;

import org.junit.jupiter.api.Test;

import static lotto.auto.common.Constants.DEFAULT_PRICE;
import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    public void LOTTOS_일급콜렉션_저장_테스트() {
        // given
        Lottos lottos = new Lottos();
        Lotto lotto = new Lotto(DEFAULT_PRICE);
        // when
        lottos.add(lotto);
        // then
        assertThat(lottos.getLottos().get(0)).isEqualTo(lotto);
    }
}
