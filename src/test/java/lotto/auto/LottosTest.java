package lotto.auto;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    private final String DEFAULT_PRICE = "1000";

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
