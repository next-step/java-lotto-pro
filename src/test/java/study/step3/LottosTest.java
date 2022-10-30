package study.step3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class LottosTest {
    @Test
    void 구입_금액대로_로또를_발급() {
        int inputMoney = 14000;
        Lottos lottos = new Lottos();

        List<Lotto> lottoList = lottos.makeLottos(inputMoney);

        assertThat(lottoList).hasSize(inputMoney / Lottos.PRICE_PER_LOTTO);
    }
}
