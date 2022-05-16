package lotto_auto.model;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoGeneratorTest {
    @Test
    void 입력된_수에_따라_로또들_생성() {
        Lottos lottos = LottoGenerator.createLottos(6);

        assertThat(lottos.getLottoList().size()).isEqualTo(6);
    }

}
